package com.kodilla.patterns.prototype;

import java.util.HashSet;
import java.util.Set;

final class Board extends Prototype {
    private String name;
    private Set<TasksList> lists = new HashSet<>();

    Board(final String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    Set<TasksList> getLists() {
        return lists;
    }

    void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(String.format("Board [%s]", name));
        for (final TasksList list : lists) {
            builder.append("\n");
            builder.append(list);
        }
        return builder.toString();
    }

    Board shallowCopy() throws CloneNotSupportedException {
        return (Board)super.clone();
    }

    Board deepCopy() throws CloneNotSupportedException {
        final Board clonedBoard = (Board)super.clone();
        clonedBoard.lists = new HashSet<>();
        for (TasksList list : lists) {
            TasksList clonedList = new TasksList(list.getName());
            for (Task task : list.getTasks()) {
                clonedList.getTasks().add(task);
            }
            clonedBoard.getLists().add(clonedList);
        }
        return clonedBoard;
    }
}
