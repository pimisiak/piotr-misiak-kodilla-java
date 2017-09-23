package com.kodilla.hibernate.tasklist;

import com.kodilla.hibernate.task.Task;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tasklists")
public class TaskList {
    private int id;
    private String listName;
    private String description;
    private List<Task> tasks = new ArrayList<>();

    public TaskList() {
    }

    public TaskList(final String listName, final String description) {
        this.listName = listName;
        this.description = description;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "listname")
    public String getListName() {
        return listName;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @OneToMany(
            targetEntity = Task.class,
            mappedBy = "taskList",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Task> getTasks() {
        return tasks;
    }

    private void setId(final int id) {
        this.id = id;
    }

    private void setListName(final String listName) {
        this.listName = listName;
    }

    private void setDescription(final String description) {
        this.description = description;
    }

    public void setTasks(final List<Task> tasks) {
        this.tasks = tasks;
    }
}
