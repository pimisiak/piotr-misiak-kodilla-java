package com.kodilla.patterns.factory.tasks;

final class TaskFactory {
    static final String SHOPPINGTASK = "Shopping Task";
    static final String PAINTINGTASK = "Painting Task";
    static final String DRIVINGTASK = "Driving Task";

    static Task makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPINGTASK:
                return new ShoppingTask(SHOPPINGTASK, "Egg", 12);
            case PAINTINGTASK:
                return new PaintingTask(PAINTINGTASK, "Red", "Rembrandt");
            case DRIVINGTASK:
                return new DrivingTask(DRIVINGTASK, "Warsaw", "FIAT 126p");
            default:
                return null;
        }
    }
}
