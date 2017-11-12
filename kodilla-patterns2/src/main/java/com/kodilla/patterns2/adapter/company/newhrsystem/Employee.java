package com.kodilla.patterns2.adapter.company.newhrsystem;

import java.math.BigDecimal;

public class Employee {
    private final String peselId;
    private final String firstname;
    private final String lastname;
    private final BigDecimal baseSalary;

    public Employee(final String peselId, final String firstname, final String lastname, final BigDecimal baseSalary) {
        this.peselId = peselId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.baseSalary = baseSalary;
    }

    public String getPeselId() {
        return peselId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Employee employee = (Employee) o;
        return peselId.equals(employee.peselId);
    }

    @Override
    public int hashCode() {
        return peselId.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Employee{peselId='%s', firstname='%s', lastname='%s', baseSalary=%s}", peselId, firstname, lastname, baseSalary);
    }
}
