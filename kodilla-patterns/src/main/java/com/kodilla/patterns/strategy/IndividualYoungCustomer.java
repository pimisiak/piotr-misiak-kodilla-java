package com.kodilla.patterns.strategy;

import com.kodilla.patterns.strategy.predictors.AggressivePredictor;

class IndividualYoungCustomer extends Customer {
    IndividualYoungCustomer(final String name) {
        super(name);
        this.buyPredictor = new AggressivePredictor();
    }
}
