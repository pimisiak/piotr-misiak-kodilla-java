package com.kodilla.patterns2.facade.api;

import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OrderFacadeAspectLogger {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacadeAspect.class);

    public void info(final OrderDto order, final Long userId) {
        LOGGER.info(String.format("Running processOrder for user with id: %d, order: %s",
                userId,
                order.getItems().stream()
                        .map(item -> String.format("item id: %d - quantity: %.2f", item.getProductId(), item.getQuantity()))
                        .collect(Collectors.toList()).toString()));
    }
}
