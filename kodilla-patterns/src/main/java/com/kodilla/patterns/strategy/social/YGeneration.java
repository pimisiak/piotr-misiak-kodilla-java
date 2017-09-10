package com.kodilla.patterns.strategy.social;

class YGeneration extends User {
    YGeneration(final String username) {
        super(username, new TwitterPublisher());
    }
}
