package com.kodilla.patterns2.observer.homework;

public interface TaskQueue extends Observable {
    boolean offer(final Task task);
    Task poll();
    Task peek();
}
