package com.kodilla.patterns.strategy;

import com.kodilla.patterns.strategy.predictors.BalancedPredictor;

class CorporateCustomer extends Customer {
    CorporateCustomer(final String name) {
        super(name);
        this.buyPredictor = new BalancedPredictor();
    }
}
