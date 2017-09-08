package com.kodilla.patterns.prototype;

final class Task {
    private final String name;

    Task(final String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("      Task[%s]", name);
    }
}
