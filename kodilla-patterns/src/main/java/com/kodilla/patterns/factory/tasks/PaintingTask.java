package com.kodilla.patterns.factory.tasks;

final class PaintingTask implements Task {
    private final String taskName;
    private final String color;
    private final String whatToPaint;
    private boolean isExecuted = false;

    PaintingTask(final String taskName, final String color, final String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
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
        return String.format("Executing task %s, to paint %s with color %s", taskName, whatToPaint, color);
    }

    @Override
    public boolean isTaskExecuted() {
        return isExecuted;
    }
}
