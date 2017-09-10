package com.kodilla.patterns.builder.bigmac;

enum Ingredient {
    LETTUCE("Lettuce"),
    ONION("Onion"),
    BACON("Bacon"),
    CUCUMBER("Cucumber"),
    CHILLIPEPPER("Chilli pepper"),
    CHEESE("Cheese"),
    MUSHROOM("Mushroom"),
    SHRIMP("Shrimp");

    String description;

    Ingredient(final String description) {
        this.description = description;
    }

    String getDescription() {
        return description;
    }
}
