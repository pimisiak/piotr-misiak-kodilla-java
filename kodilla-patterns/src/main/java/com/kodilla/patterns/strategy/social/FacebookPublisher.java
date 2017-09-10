package com.kodilla.patterns.strategy.social;

class FacebookPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "Facebook";
    }
}