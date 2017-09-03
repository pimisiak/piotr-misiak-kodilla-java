package com.kodilla.good.patterns.challenges.food2door;

class ProductOrderService implements OrderService {
    @Override
    public OrderDto processOrder(final Order order) {
        System.out.printf("Processing order %d for %s %s.", order.getId(), order.getUser().getFirstName(), order.getUser().getLastName());
        return new OrderDto(order, true);
    }
}
