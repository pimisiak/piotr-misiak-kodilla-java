package com.kodilla.stream.portfolio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class Board {
    private final List<TaskList> taskLists = new ArrayList<>();
    private final String name;

    Board(final String name) {
        this.name = name;
    }

    void addTaskList(final TaskList taskList) {
        taskLists.add(taskList);
    }

    boolean removeTaskList(final TaskList taskList) {
        return taskLists.remove(taskList);
    }

    List<TaskList> getTaskLists() {
        return Collections.unmodifiableList(taskLists);
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Board{taskLists=" + taskLists + ", name='" + name + '\'' + '}';
    }
}
