package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

final class TaskList {
    private final List<String> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    void addTask(final String task) {
        tasks.add(task);
    }

    String getTask(final int index) {
        return tasks.get(index);
    }
}
