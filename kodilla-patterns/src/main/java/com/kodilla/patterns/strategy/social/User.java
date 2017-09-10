package com.kodilla.patterns.strategy.social;

class User {
    private final String username;
    private SocialPublisher socialPublisher;

    User(final String username, final SocialPublisher socialPublisher) {
        this.username = username;
        this.socialPublisher = socialPublisher;
    }

    public String getUsername() {
        return username;
    }

    String sharePost() {
        return socialPublisher.share();
    }

    void setSocialPublisher(final SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }
}
