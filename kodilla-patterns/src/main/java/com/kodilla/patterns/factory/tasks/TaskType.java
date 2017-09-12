package com.kodilla.patterns.factory.tasks;

enum TaskType {
    SHOPPINGTASK("Shopping Task"),
    PAINTINGTASK("Painting Task"),
    DRIVINGTASK("Driving Task");

    private String description;

    TaskType(final String description) {
        this.description = description;
    }

    String getDescription() {
        return description;
    }
}