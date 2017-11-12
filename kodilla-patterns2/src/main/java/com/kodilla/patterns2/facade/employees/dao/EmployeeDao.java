package com.kodilla.patterns2.facade.employees.dao;

import com.kodilla.patterns2.facade.employees.entity.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
    @Query
    List<Employee> searchByName(@Param("NAME") final String name);
}
