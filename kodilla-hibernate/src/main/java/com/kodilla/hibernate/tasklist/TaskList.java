package com.kodilla.hibernate.tasklist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tasklists")
public class TaskList {
    private int id;
    private String listName;
    private String description;

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

    private void setId(final int id) {
        this.id = id;
    }

    private void setListName(final String listName) {
        this.listName = listName;
    }

    private void setDescription(final String description) {
        this.description = description;
    }
}
