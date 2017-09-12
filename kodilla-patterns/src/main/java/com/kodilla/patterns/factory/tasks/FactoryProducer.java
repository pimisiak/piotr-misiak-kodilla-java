package com.kodilla.patterns.factory.tasks;

class FactoryProducer {
    static AbstractTaskFactory getTaskFactory(final TaskType type) {
        switch (type) {
            case DRIVINGTASK:
                return new DrivingTaskFactory();
            case PAINTINGTASK:
                return new PaintingTaskFactory();
            case SHOPPINGTASK:
                return new ShoppingTaskFactory();
            default:
                throw new IllegalArgumentException();
        }
    }
}
