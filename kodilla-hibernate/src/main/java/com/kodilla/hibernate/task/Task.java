package com.kodilla.hibernate.task;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tasks")
public class Task {
    private int id;
    private String description;
    private Date created;
    private int duration;

    public Task() {
    }

    /**
     * Constructs a Task object.
     *
     * @param description Description of task
     * @param duration Duration of task
     */
    public Task(final String description, final int duration) {
        this.description = description;
        this.duration = duration;
        this.created = new Date();
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @NotNull
    @Column(name = "created")
    public Date getCreated() {
        return created;
    }

    @Column(name = "duration")
    public int getDuration() {
        return duration;
    }

    private void setId(final int id) {
        this.id = id;
    }

    private void setDescription(final String description) {
        this.description = description;
    }

    private void setCreated(final Date created) {
        this.created = created;
    }

    private void setDuration(final int duration) {
        this.duration = duration;
    }
}
