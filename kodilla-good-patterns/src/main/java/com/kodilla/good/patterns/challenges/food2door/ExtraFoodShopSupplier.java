package com.kodilla.good.patterns.challenges.food2door;

import java.util.Map;

final class ExtraFoodShopSupplier implements Supplier {
    private final OrderService orderService;

    ExtraFoodShopSupplier(final OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public boolean process(final Order order) {
        System.out.println("ExtraFoodShop: receiving order.");
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
                .allMatch(es -> es.getKey().getPrice() >= 24.45 && es.getKey().getFoodType().equals(FoodType.MEAT));
    }
}
