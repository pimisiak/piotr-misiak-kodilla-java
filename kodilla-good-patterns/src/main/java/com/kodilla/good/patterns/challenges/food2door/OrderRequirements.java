package com.kodilla.good.patterns.challenges.food2door;

final class OrderRequirements {
    private final Order order;
    private final Supplier supplier;

    OrderRequirements(final Order order, final Supplier supplier) {
        this.order = order;
        this.supplier = supplier;
    }

    Order getOrder() {
        return order;
    }

    Supplier getSupplier() {
        return supplier;
    }
}
