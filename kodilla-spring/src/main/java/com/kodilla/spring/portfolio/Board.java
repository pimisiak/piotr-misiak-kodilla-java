package com.kodilla.spring.portfolio;

final class Board {
    private final TaskList toDoList;
    private final TaskList inProgressList;
    private final TaskList doneList;

    Board(final TaskList toDoList, final TaskList inProgressList, final TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    TaskList getToDoList() {
        return toDoList;
    }

    TaskList getInProgressList() {
        return inProgressList;
    }

    TaskList getDoneList() {
        return doneList;
    }
}
