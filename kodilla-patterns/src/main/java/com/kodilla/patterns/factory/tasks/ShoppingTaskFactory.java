package com.kodilla.patterns.factory.tasks;

class ShoppingTaskFactory extends AbstractTaskFactory {
    @Override
    Task getDrivingTask(final String taskName, final String where, final String using) {
        throw new UnsupportedOperationException();
    }

    @Override
    Task getPaintingTask(final String taskName, final String color, final String whatToPaint) {
        throw new UnsupportedOperationException();
    }

    @Override
    Task getShoppingTask(final String taskName, final String whatToBuy, final double quantity) {
        return new ShoppingTask(taskName, whatToBuy, quantity);
    }
}
