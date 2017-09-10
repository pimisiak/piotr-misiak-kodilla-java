package com.kodilla.patterns.strategy.social;

class Millennials extends User {
    Millennials(final String username) {
        super(username, new SnapchatPublisher());
    }
}
