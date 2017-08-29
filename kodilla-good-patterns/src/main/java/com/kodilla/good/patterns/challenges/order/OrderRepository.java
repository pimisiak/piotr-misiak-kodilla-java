package com.kodilla.good.patterns.challenges.order;

interface OrderRepository {
    OrderDto createOrder(final Order order);
}
