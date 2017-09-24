package com.kodilla.hibernate.task;

import com.kodilla.hibernate.tasklist.TaskList;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamedQueries({
        @NamedQuery(
                name = "Task.retrieveLongTasks",
                query = "FROM Task WHERE duration > 10"
        ),
        @NamedQuery(
                name = "Task.retrieveShortTasks",
                query = "FROM Task WHERE duration <= 10"
        ),
        @NamedQuery(
                name = "Task.retrieveTasksWithDurationLongerThan",
                query = "FROM Task WHERE duration > :DURATION"
        )
})
@NamedNativeQuery(
        name = "Task.retrieveTasksWithEnoughTime",
        query = "SELECT * FROM tasks WHERE DATEDIFF(DATE_ADD(created, INTERVAL duration DAY), NOW()) > 5",
        resultClass = Task.class
)
@Entity
@Table(name = "tasks")
public class Task {
    private int id;
    private String description;
    private Date created;
    private int duration;
    private TaskFinancialDetails taskFinancialDetails;
    private TaskList taskList;

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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tasks_financials_id")
    public TaskFinancialDetails getTaskFinancialDetails() {
        return taskFinancialDetails;
    }

    @ManyToOne
    @JoinColumn(name = "tasklist_id")
    public TaskList getTaskList() {
        return taskList;
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

    public void setTaskFinancialDetails(final TaskFinancialDetails taskFinancialDetails) {
        this.taskFinancialDetails = taskFinancialDetails;
    }

    public void setTaskList(final TaskList taskList) {
        this.taskList = taskList;
    }
}
