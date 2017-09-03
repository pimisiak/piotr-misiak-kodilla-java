package com.kodilla.good.patterns.challenges.food2door;

import java.time.LocalDate;
import java.util.Map;

final class HealthyShopSupplier implements Supplier {
    private final OrderService orderService;

    HealthyShopSupplier(final OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public boolean process(final Order order) {
        System.out.println("HealthyShop: receiving order.");
        if (ifProductsAvailable(order.getProducts())) {
            System.out.println("Products are available.");
            OrderDto processedOrder = orderService.processOrder(order);
            return processedOrder.isExecuted();
        }
        System.out.println("Products are unavailable.");
        return false;
    }

    private boolean ifProductsAvailable(final Map<Food, Integer> products) {
        return products.entrySet().stream()
                .anyMatch(es -> es.getKey().getCalories() <= 150 && es.getKey().getExpiringDate().isBefore(LocalDate.now()));
    }
}
