package com.kodilla.good.patterns.challenges.food2door;

import java.time.LocalDate;

final class FoodImpl implements Food {
    private final int id;
    private final String productName;
    private final FoodType foodType;
    private final int calories;
    private final LocalDate expiringDate;
    private final double price;

    private FoodImpl(final Builder builder) {
        this.id = builder.id;
        this.productName = builder.productName;
        this.foodType = builder.foodType;
        this.calories = builder.calories;
        this.expiringDate = builder.expiringDate;
        this.price = builder.price;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public FoodType getFoodType() {
        return foodType;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public LocalDate getExpiringDate() {
        return expiringDate;
    }

    @Override
    public double getPrice() {
        return price;
    }

    static class Builder {
        private final int id;
        private final String productName;
        private final FoodType foodType;
        private int calories;
        private LocalDate expiringDate;
        private double price;

        Builder(final int id, final String productName, final FoodType foodType) {
            this.id = id;
            this.productName = productName;
            this.foodType = foodType;
        }

        Builder calories(final int calories) {
            this.calories = calories;
            return this;
        }

        Builder expiringDate(final LocalDate expiringDate) {
            this.expiringDate = expiringDate;
            return this;
        }

        Builder price(final double price) {
            this.price = price;
            return this;
        }

        FoodImpl build() {
            return new FoodImpl(this);
        }
    }
}
