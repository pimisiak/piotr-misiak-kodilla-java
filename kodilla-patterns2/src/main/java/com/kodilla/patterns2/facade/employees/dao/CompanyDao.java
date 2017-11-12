package com.kodilla.patterns2.facade.employees.dao;

import com.kodilla.patterns2.facade.employees.entity.Company;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDao extends JpaRepository<Company, Integer> {
    @Query
    List<Company> searchByName(@Param("NAME") final String name);
}
