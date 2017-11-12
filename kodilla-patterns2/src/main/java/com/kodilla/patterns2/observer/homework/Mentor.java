package com.kodilla.patterns2.observer.homework;

public final class Mentor implements Observer {
    private String firstname;
    private String lastname;
    private int toCheckTasks = 0;

    public Mentor(final String firstname, final String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getToCheckTasks() {
        return toCheckTasks;
    }

    @Override
    public void update(final TaskQueue taskQueue) {
        final Task task = taskQueue.peek();
        toCheckTasks++;
        System.out.println(String.format("New task to check:%nDescription: %s%nMessage: %s%nUrl: %s",
                task.getDescription(),
                task.getMessage(),
                task.getTaskURL()));
        System.out.println(String.format("All tasks: %d", toCheckTasks));
    }
}
