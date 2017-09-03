package com.kodilla.good.patterns.challenges.food2door;

final class SupplierOrderService {
    OrderDto delegateOrderToSupplier(final OrderRequirements orderRequirements) {
        boolean isExecuted = orderRequirements.getSupplier().process(orderRequirements.getOrder());
        return new OrderDto(orderRequirements.getOrder(), isExecuted);
    }
}
