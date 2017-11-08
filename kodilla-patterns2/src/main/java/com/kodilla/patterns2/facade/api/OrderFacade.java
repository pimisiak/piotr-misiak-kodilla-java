package com.kodilla.patterns2.facade.api;

import com.kodilla.patterns2.facade.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacade.class);
    @Autowired
    private ShopService shopService;

    public void processOrder(final OrderDto order, final Long userId) throws OrderProcessingException {
        final long orderId = shopService.openOrder(userId);
        boolean wasError = false;
        LOGGER.info(String.format("Registering new order, ID: %d", orderId));
        if (orderId < 0) {
            LOGGER.error(OrderProcessingException.ERR_NOT_AUTHORISED);
            wasError = true;
            throw new OrderProcessingException(OrderProcessingException.ERR_NOT_AUTHORISED);
        }
        try {
            for (ItemDto item : order.getItems()) {
                LOGGER.info(String.format("Adding item %d, %.2f pcs", item.getProductId(), item.getQuantity()));
                shopService.addItem(orderId, item.getProductId(), item.getQuantity());
            }
            final BigDecimal value = shopService.calculateValue(orderId);
            LOGGER.info(String.format("Order value is %.2f USD", value));
            if (!shopService.doPayment(orderId)) {
                LOGGER.error(OrderProcessingException.ERR_PAYMENT_REJECTED);
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_PAYMENT_REJECTED);

            }
            LOGGER.info("Payment for order was done");
            if (!shopService.verifyOrder(orderId)) {
                LOGGER.error(OrderProcessingException.ERR_VERIFICATION_ERROR);
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_VERIFICATION_ERROR);
            }
            LOGGER.info("Order is ready to submit");
            if (!shopService.submitOrder(orderId)) {
                LOGGER.error(OrderProcessingException.ERR_SUBMITTING_ERROR);
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_SUBMITTING_ERROR);
            }
            LOGGER.info(String.format("Order %d submitted", orderId));
        } finally {
            if (wasError) {
                LOGGER.info(String.format("Cancelling order %d", orderId));
                shopService.cancelOrder(orderId);
            }
        }
    }
}
