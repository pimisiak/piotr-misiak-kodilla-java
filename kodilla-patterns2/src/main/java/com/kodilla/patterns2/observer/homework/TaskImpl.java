package com.kodilla.patterns2.observer.homework;

public class TaskImpl implements Task {
    private String url;
    private String message;
    private String description;

    public TaskImpl(final String url, final String message, final String description) {
        this.url = url;
        this.message = message;
        this.description = description;
    }

    @Override
    public String getTaskURL() {
        return url;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
