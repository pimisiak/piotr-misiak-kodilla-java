package com.kodilla.hibernate.manytomany;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamedQuery(
        name = "Employee.searchEmployeesWithLastname",
        query = "FROM Employee WHERE lower(lastname) = lower(:LASTNAME)"
)
@Entity
@Table(name = "employees")
public class Employee {
    private int id;
    private String firstname;
    private String lastname;
    private List<Company> companies = new ArrayList<>();

    public Employee() {
    }

    public Employee(final String firstname, final String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "employee_id", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    @NotNull
    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "company_employee",
            joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "company_id", referencedColumnName = "company_id")}
    )
    public List<Company> getCompanies() {
        return companies;
    }

    private void setId(final int id) {
        this.id = id;
    }

    private void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    private void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public void setCompanies(final List<Company> companies) {
        this.companies = companies;
    }
}
