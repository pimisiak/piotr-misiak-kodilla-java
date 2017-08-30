package com.kodilla.spring.forum;

import org.springframework.stereotype.Component;

@Component
class ForumUser {
    private final String username;

    ForumUser() {
        this.username = "John Smith";
    }

    String getUsername() {
        return username;
    }
}
