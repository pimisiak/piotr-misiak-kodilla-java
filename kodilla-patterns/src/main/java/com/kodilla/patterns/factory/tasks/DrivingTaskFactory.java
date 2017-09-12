package com.kodilla.patterns.factory.tasks;

class DrivingTaskFactory extends AbstractTaskFactory {
    @Override
    Task getDrivingTask(final String taskName, final String where, final String using) {
        return new DrivingTask(taskName, where, using);
    }

    @Override
    Task getPaintingTask(final String taskName, final String color, final String whatToPaint) {
        throw new UnsupportedOperationException();
    }

    @Override
    Task getShoppingTask(final String taskName, final String whatToBuy, final double quantity) {
        throw new UnsupportedOperationException();
    }
}
