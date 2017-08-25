package com.kodilla.good.patterns.challenges.order;

final class ProductOrderRepository implements OrderRepository {
    @Override
    public void createOrder(final Order order) {
        System.out.printf("Inserting order %d into database.%n", order.getOrderId());
    }
}
