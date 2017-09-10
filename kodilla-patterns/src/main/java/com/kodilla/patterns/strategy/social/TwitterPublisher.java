package com.kodilla.patterns.strategy.social;

class TwitterPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "Twitter";
    }
}
