package com.kodilla.patterns2.observer.homework;

public class TaskQueueException extends RuntimeException {
    public static final String ERR_EMPTY_QUEUE = "Queue is empty!";

    public TaskQueueException(final String message) {
        super(message);
    }
}
