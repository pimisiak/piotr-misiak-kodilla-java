package com.kodilla.patterns.factory.tasks;

final class DrivingTask implements Task {
    private final String taskName;
    private final String where;
    private final String using;
    private boolean isExecuted = false;

    DrivingTask(final String taskName, final String where, final String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
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
        return String.format("Executing task %s in %s with %s", taskName, where, using);
    }

    @Override
    public boolean isTaskExecuted() {
        return isExecuted;
    }
}
