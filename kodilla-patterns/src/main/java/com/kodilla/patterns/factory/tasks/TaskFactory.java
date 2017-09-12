package com.kodilla.patterns.factory.tasks;

final class TaskFactory {
    static Task makeTask(final TaskType taskType) {
        switch (taskType) {
            case SHOPPINGTASK:
                return new ShoppingTask(TaskType.SHOPPINGTASK.getDescription(), "Egg", 12);
            case PAINTINGTASK:
                return new PaintingTask(TaskType.PAINTINGTASK.getDescription(), "Red", "Rembrandt");
            case DRIVINGTASK:
                return new DrivingTask(TaskType.DRIVINGTASK.getDescription(), "Warsaw", "FIAT 126p");
            default:
                throw new IllegalArgumentException();
        }
    }
}
