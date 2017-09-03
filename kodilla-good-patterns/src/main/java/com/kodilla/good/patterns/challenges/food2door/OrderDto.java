package com.kodilla.good.patterns.challenges.food2door;

final class OrderDto {
    private final Order order;
    private final boolean isExecuted;

    OrderDto(final Order order, final boolean isExecuted) {
        this.order = order;
        this.isExecuted = isExecuted;
    }

    Order getOrder() {
        return order;
    }

    boolean isExecuted() {
        return isExecuted;
    }
}
