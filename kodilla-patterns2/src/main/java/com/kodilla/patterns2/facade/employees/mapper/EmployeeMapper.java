package com.kodilla.patterns2.facade.employees.mapper;

import com.kodilla.patterns2.facade.employees.dto.EmployeeDto;
import com.kodilla.patterns2.facade.employees.entity.Employee;
import java.util.List;

public interface EmployeeMapper {
    EmployeeDto mapToEmployeeDto(final Employee employee);
    List<EmployeeDto> mapToEmployeeDto(final List<Employee> employees);
    Employee mapToEmployee(final EmployeeDto employeeDto);
    List<Employee> mapToEmployee(final List<EmployeeDto> employeeDtos);
}
