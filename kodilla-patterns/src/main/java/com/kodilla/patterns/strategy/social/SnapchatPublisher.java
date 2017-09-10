package com.kodilla.patterns.strategy.social;

class SnapchatPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "Snapchat";
    }
}
