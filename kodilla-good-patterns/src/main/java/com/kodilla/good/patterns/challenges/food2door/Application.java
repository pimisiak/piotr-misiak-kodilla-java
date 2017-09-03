package com.kodilla.good.patterns.challenges.food2door;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Application {
    public static void main(final String[] args) {
        final User user = new User.UserBuilder("user123")
                .address("ul Rola 12/13")
                .firstName("Bartek")
                .lastName("Bartkowski")
                .email("bart@bart.com")
                .bankAccountNumber("9999-0000-9999-0000-9999")
                .build();

        final Food chickenBreast = new FoodImpl.Builder(123, "Chicken Breast", FoodType.MEAT)
                .expiringDate(LocalDate.of(2017, 9, 20))
                .calories(150)
                .price(27.50)
                .build();
        final Food tomato = new FoodImpl.Builder(124, "Tomato", FoodType.VEGETABLE)
                .expiringDate(LocalDate.of(2017, 9, 10))
                .calories(25)
                .price(2.50)
                .build();
        final Food cheese = new FoodImpl.Builder(125, "Cheese", FoodType.DAIRY)
                .expiringDate(LocalDate.of(2017, 9, 2))
                .calories(50)
                .price(7.50)
                .build();
        final Food apple = new FoodImpl.Builder(123, "Chicken Breast", FoodType.FRUIT)
                .expiringDate(LocalDate.of(2017, 9, 15))
                .calories(10)
                .price(1.50)
                .build();
        final Food bread = new FoodImpl.Builder(123, "Bread", FoodType.CEREAL)
                .expiringDate(LocalDate.of(2017, 9, 5))
                .calories(150)
                .price(3.50)
                .build();

        final Order orderForFood = new OrderImpl.Builder(123)
                .user(user)
                .dateOfOrder(LocalDateTime.of(2017, 8, 22, 12, 55, 15))
                .shippingAddress(user.getAddress())
                .addProduct(tomato, 5)
                .addProduct(chickenBreast, 1)
                .addProduct(cheese, 2)
                .addProduct(apple, 2)
                .addProduct(bread, 3)
                .build();

        final OrderRequirements orderRequirementsExtraFood = new OrderRequirements(orderForFood, new ExtraFoodShopSupplier(new ProductOrderService()));
        final OrderRequirements orderRequirementsGlutenFree = new OrderRequirements(orderForFood, new GlutenFreeShopSupplier(new ProductOrderService()));
        final OrderRequirements orderRequirementsHealthy = new OrderRequirements(orderForFood, new HealthyShopSupplier(new ProductOrderService()));

        final SupplierOrderService supplierOrderService = new SupplierOrderService();
        supplierOrderService.delegateOrderToSupplier(orderRequirementsExtraFood);
        supplierOrderService.delegateOrderToSupplier(orderRequirementsGlutenFree);
        supplierOrderService.delegateOrderToSupplier(orderRequirementsHealthy);
    }
}
