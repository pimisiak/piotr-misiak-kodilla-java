package com.kodilla.patterns2.facade.employees.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(
        name = "Employee.searchByName",
        query = "FROM Employee WHERE concat(firstname, ' ', lastname) LIKE :NAME"
)
@Entity
@Table(name = "Employees")
public final class Employee {
    private int id;
    private String firstname;
    private String lastname;

    public Employee() {
    }

    public Employee(final int id, final String firstname, final String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "employee_id")
    public int getId() {
        return id;
    }

    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }
}
