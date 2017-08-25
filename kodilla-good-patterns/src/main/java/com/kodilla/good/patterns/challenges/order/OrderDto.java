package com.kodilla.good.patterns.challenges.order;

final class OrderDto {
    private final Order order;
    private final boolean isProccessed;

    OrderDto(final Order order, final boolean isProccessed) {
        this.order = order;
        this.isProccessed = isProccessed;
    }

    public Order getOrder() {
        return order;
    }

    public boolean isProcessed() {
        return isProccessed;
    }
}
