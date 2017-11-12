package com.kodilla.patterns2.facade.employees.service;

import com.kodilla.patterns2.facade.employees.dto.EmployeeDto;
import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> findByName(final String name);
    EmployeeDto save(final EmployeeDto employeeDto);
}
