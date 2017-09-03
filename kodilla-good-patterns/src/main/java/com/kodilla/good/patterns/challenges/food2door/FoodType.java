package com.kodilla.good.patterns.challenges.food2door;

enum FoodType {
    VEGETABLE("Vegetable"), FRUIT("Fruit"), MEAT("Meat"), FISH("Fish"), DAIRY("Dairy"), CEREAL("Cereal");

    String description;

    FoodType(final String description) {
        this.description = description;
    }

    String getDescription() {
        return description;
    }
}
