package com.kodilla.patterns.strategy.social;

abstract class User {
    private final String username;
    private SocialPublisher socialPublisher;

    User(final String username, final SocialPublisher socialPublisher) {
        if (socialPublisher == null || username == null) {
            throw new IllegalArgumentException();
        }
        this.username = username;
        this.socialPublisher = socialPublisher;
    }

    String getUsername() {
        return username;
    }

    String sharePost() {
        return socialPublisher.share();
    }

    void setSocialPublisher(final SocialPublisher socialPublisher) {
        if (socialPublisher == null) {
            throw new IllegalArgumentException();
        }
        this.socialPublisher = socialPublisher;
    }
}
