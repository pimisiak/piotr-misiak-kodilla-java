package com.kodilla.patterns.strategy;

class Customer {
    private final String name;
    BuyPredictor buyPredictor;

    Customer(final String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    String predict() {
        return buyPredictor.predictWhatToBuy();
    }

    void setBuyingStrategy(final BuyPredictor buyPredictor) {
        this.buyPredictor = buyPredictor;
    }
}
