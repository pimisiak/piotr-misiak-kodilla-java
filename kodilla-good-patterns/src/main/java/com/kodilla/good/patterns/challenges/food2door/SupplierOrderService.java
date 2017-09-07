package com.kodilla.good.patterns.challenges.food2door;

final class SupplierOrderService {
    private final SupplierRegister supplierRegister;

    SupplierOrderService(final SupplierRegister supplierRegister) {
        this.supplierRegister = supplierRegister;
    }

    OrderDto delegateOrderToSupplier(final Order order) {
        boolean isExecuted = false;
        try {
            isExecuted = supplierRegister.getSupplier(order.getSupplierId()).process(order);
        } catch (MissingSupplierException e) {
            System.out.println(e.getMessage());
        }
        return new OrderDto(order, isExecuted);
    }
}
