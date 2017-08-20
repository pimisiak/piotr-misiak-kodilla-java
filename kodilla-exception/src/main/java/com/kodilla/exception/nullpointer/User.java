package com.kodilla.exception.nullpointer;

final class User {
    private final String name;

    User(final String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}
