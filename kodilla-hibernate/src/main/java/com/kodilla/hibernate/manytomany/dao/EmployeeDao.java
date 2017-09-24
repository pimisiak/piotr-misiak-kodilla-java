package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
    @Query
    List<Employee> searchEmployeesWithLastname(@Param("LASTNAME") final String lastname);
}
