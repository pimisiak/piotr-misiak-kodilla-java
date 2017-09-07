package com.kodilla.good.patterns.challenges.food2door;

final class SupplierOrderService {
    private final SupplierRegister supplierRegister;

    SupplierOrderService(final SupplierRegister supplierRegister) {
        this.supplierRegister = supplierRegister;
    }

    OrderDto delegateOrderToSupplier(final Order order) {
        final boolean isExecuted = supplierRegister.getSupplier(order.getSupplierId()).process(order);
        return new OrderDto(order, isExecuted);
    }
}
