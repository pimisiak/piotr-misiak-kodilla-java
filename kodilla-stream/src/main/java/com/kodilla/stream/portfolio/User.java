package com.kodilla.stream.portfolio;

final class User {
    private final String username;
    private final String realName;

    User(final String username, final String realName) {
        this.username = username;
        this.realName = realName;
    }

    String getUsername() {
        return username;
    }

    String getRealName() {
        return realName;
    }

    @Override
    public String toString() {
        return "User{username='" + username + '\'' + ", realName='" + realName + '\'' + '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final User user = (User) o;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
