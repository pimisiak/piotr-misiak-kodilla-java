package com.kodilla.stream.portfolio;

import java.time.LocalDate;

final class Task {
    private final String title;
    private final String description;
    private final User assignedUser;
    private final User creator;
    private final LocalDate created;
    private final LocalDate deadline;

    private Task(final TaskBuilder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.assignedUser = builder.assignedUser;
        this.creator = builder.creator;
        this.created = builder.created;
        this.deadline = builder.deadline;
    }

    String getTitle() {
        return title;
    }

    String getDescription() {
        return description;
    }

    User getAssignedUser() {
        return assignedUser;
    }

    User getCreator() {
        return creator;
    }

    LocalDate getCreated() {
        return created;
    }

    LocalDate getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return "Task{title='" + title + '\'' + ", description='" + description + '\'' + ", assignedUser=" + assignedUser + ", creator=" + creator
                + ", created=" + created + ", deadline=" + deadline + '}';
    }

    static class TaskBuilder {
        private String title;
        private String description;
        private User assignedUser;
        private User creator;
        private LocalDate created;
        private LocalDate deadline;

        TaskBuilder title(final String title) {
            this.title = title;
            return this;
        }

        TaskBuilder description(final String description) {
            this.description = description;
            return this;
        }

        TaskBuilder assignedUser(final User assignedUser) {
            this.assignedUser = assignedUser;
            return this;
        }

        TaskBuilder creator(final User creator) {
            this.creator = creator;
            return this;
        }

        TaskBuilder created(final LocalDate created) {
            this.created = created;
            return this;
        }

        TaskBuilder deadline(final LocalDate deadline) {
            this.deadline = deadline;
            return this;
        }

        Task build() {
            return new Task(this);
        }
    }
}
