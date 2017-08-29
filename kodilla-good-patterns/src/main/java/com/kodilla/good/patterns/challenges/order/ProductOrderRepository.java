package com.kodilla.good.patterns.challenges.order;

final class ProductOrderRepository implements OrderRepository {
    private static int nextId = 0;

    @Override
    public OrderDto createOrder(final Order order) {
        System.out.printf("Inserting order %d into database.%n", ++nextId);
        return new OrderDto(order, nextId, true);
    }
}
