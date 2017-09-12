package com.kodilla.patterns.factory.tasks;

class PaintingTaskFactory extends AbstractTaskFactory {
    @Override
    Task getDrivingTask(final String taskName, final String where, final String using) {
        throw new UnsupportedOperationException();
    }

    @Override
    Task getPaintingTask(final String taskName, final String color, final String whatToPaint) {
        return new PaintingTask(taskName, color, whatToPaint);
    }

    @Override
    Task getShoppingTask(final String taskName, final String whatToBuy, final double quantity) {
        throw new UnsupportedOperationException();
    }
}
