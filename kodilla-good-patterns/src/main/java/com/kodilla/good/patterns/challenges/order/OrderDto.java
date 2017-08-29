package com.kodilla.good.patterns.challenges.order;

final class OrderDto implements Information {
    private final Order order;
    private final int id;
    private final boolean isProcessed;

    OrderDto(final Order order, final int id, final boolean isProccessed) {
        this.order = order;
        this.id = id;
        this.isProcessed = isProccessed;
    }

    @Override
    public String getInformation() {
        if (isProcessed) {
            return String.format("Creation of order: %s has completed successfully.%n", order.getInformation());
        }
        return String.format("Creation of order: %s has been terminated.%n", order.getInformation());
    }

    Order getOrder() {
        return order;
    }

    boolean isProcessed() {
        return isProcessed;
    }

    int getId() {
        return id;
    }
}
