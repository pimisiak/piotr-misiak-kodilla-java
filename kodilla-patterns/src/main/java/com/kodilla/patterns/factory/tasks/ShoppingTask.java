package com.kodilla.patterns.factory.tasks;

final class ShoppingTask implements Task {
    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    private boolean isExecuted = false;

    ShoppingTask(final String taskName, final String whatToBuy, final double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public String executeTask() {
        if (isExecuted) {
            return String.format("Task %s is already executed!", taskName);
        }
        isExecuted = true;
        return String.format("Executing task %s to buy %s %s", taskName, quantity, whatToBuy);
    }

    @Override
    public boolean isTaskExecuted() {
        return isExecuted;
    }
}
