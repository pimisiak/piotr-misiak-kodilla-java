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
        if (paymentService.processPayment(order.orderPrice())) {
            productOrderRepository.createOrder(order);
            informationService.inform(order.getUser());
            return new OrderDto(order, true);
        }
        return new OrderDto(order, false);
    }
}
