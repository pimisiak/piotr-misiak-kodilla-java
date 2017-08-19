package com.kodilla.stream.portfolio;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

final class TaskList {
    private final List<Task> tasks = new LinkedList<>();
    private final String name;

    TaskList(final String name) {
        this.name = name;
    }

    void addTask(final Task task) {
        tasks.add(task);
    }

    boolean removeTask(final Task task) {
        return tasks.remove(task);
    }

    List<Task> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TaskList{tasks=" + tasks + ", name='" + name + '\'' + '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final TaskList taskList = (TaskList) o;
        return name.equals(taskList.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
