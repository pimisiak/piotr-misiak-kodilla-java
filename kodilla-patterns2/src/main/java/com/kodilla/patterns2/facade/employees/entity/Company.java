package com.kodilla.patterns2.facade.employees.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamedQuery(
        name = "Company.searchByName",
        query = "FROM Company WHERE name LIKE :NAME"
)
@Entity
@Table(name = "Companies")
public final class Company {
    private int id;
    private String name;

    public Company() {
    }

    public Company(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "company_id")
    public int getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
