package com.kodilla.testing.user;

public class SimpleUser {
    private final String username;
    private final String realname;

    public SimpleUser(final String username, final String realname) {
        this.username = username;
        this.realname = realname;
    }

    public String getUsername() {
        return username;
    }

    public String getRealname() {
        return realname;
    }
}
