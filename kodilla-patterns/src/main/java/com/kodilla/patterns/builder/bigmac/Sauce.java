package com.kodilla.patterns.builder.bigmac;

enum Sauce {
    STANDARD("Standard"),
    BBQ("Barbecue"),
    ISLAND("1000 Island");

    String description;

    Sauce(final String description) {
        this.description = description;
    }

    String getDescription() {
        return description;
    }
}
