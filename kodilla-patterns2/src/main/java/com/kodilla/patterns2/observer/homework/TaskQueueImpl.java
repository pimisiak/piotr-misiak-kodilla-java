package com.kodilla.patterns2.observer.homework;

import com.google.common.base.Preconditions;

import static java.util.Optional.ofNullable;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TaskQueueImpl implements TaskQueue {
    private final List<Observer> observers = new ArrayList<>();
    private final Deque<Task> tasks = new ArrayDeque<>();

    @Override
    public boolean registerObserver(final Observer observer) {
        return observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (final Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(final Observer observer) {
        observers.remove(observer);
    }

    @Override
    public boolean offer(final Task task) {
        final boolean result = tasks.offerLast(task);
        if (result) {
            notifyObservers();
        }
        return tasks.offerLast(task);
    }

    @Override
    public Task poll() {
        return ofNullable(tasks.pollFirst()).orElseThrow(() -> new TaskQueueException(TaskQueueException.ERR_EMPTY_QUEUE));
    }

    @Override
    public Task peek() {
        return ofNullable(tasks.peekFirst()).orElseThrow(() -> new TaskQueueException(TaskQueueException.ERR_EMPTY_QUEUE));
    }
}
