package com.kodilla.patterns.prototype;

import java.util.ArrayList;
import java.util.List;

final class TasksList {
    private final String name;
    private final List<Task> tasks = new ArrayList<>();

    TasksList(final String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    List<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(String.format("   List [%s]", name));
        for (final Task task : tasks) {
            builder.append("\n");
            builder.append(task) ;
        }
        return builder.toString();
    }
}
