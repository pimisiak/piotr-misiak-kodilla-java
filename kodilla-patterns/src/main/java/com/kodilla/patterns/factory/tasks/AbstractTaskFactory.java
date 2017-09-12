package com.kodilla.patterns.factory.tasks;

abstract class AbstractTaskFactory {
    abstract Task getDrivingTask(final String taskName, final String where, final String using);
    abstract Task getPaintingTask(final String taskName, final String color, final String whatToPaint);
    abstract Task getShoppingTask(final String taskName, final String whatToBuy, final double quantity);
}
