package com.kodilla.good.patterns.challenges.order;

final class ProductOrderService {
    private final PaymentService paymentService;
    private final InformationService informationService;
    private final OrderRepository productOrderRepository;

    ProductOrderService(final PaymentService paymentService, final InformationService informationService,
                               final OrderRepository productOrderRepository) {
        this.paymentService = paymentService;
        this.informationService = informationService;
        this.productOrderRepository = productOrderRepository;
    }

    OrderDto processOrder(final Order order) {
        final OrderDto processedOrder = productOrderRepository.createOrder(order);
        if (processedOrder.isProcessed()) {
            informationService.inform(processedOrder);
            final PaymentResult paymentResult = paymentService.processPayment(new PaymentRequirements(order.orderPrice(), order.getUser()));
            informationService.inform(new InformationImpl.Builder()
                    .information(paymentResult.getInformation())
                    .user(order.getUser())
                    .build());
            return processedOrder;
        }
        informationService.inform(processedOrder);
        return processedOrder;
    }
}
