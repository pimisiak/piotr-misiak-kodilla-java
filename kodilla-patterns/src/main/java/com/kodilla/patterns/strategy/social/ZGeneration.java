package com.kodilla.patterns.strategy.social;

class ZGeneration extends User {
    ZGeneration(final String username) {
        super(username, new FacebookPublisher());
    }
}
