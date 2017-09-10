package com.kodilla.patterns.strategy;

import com.kodilla.patterns.strategy.predictors.ConservativePredictor;

class IndividualCustomer extends Customer {
    IndividualCustomer(final String name) {
        super(name);
        this.buyPredictor = new ConservativePredictor();
    }
}
