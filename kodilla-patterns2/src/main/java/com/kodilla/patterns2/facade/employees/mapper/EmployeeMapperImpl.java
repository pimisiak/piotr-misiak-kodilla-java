package com.kodilla.patterns2.facade.employees.mapper;

import com.google.common.base.Preconditions;
import com.kodilla.patterns2.facade.employees.dto.EmployeeDto;
import com.kodilla.patterns2.facade.employees.entity.Employee;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapperImpl implements EmployeeMapper {
    @Override
    public EmployeeDto mapToEmployeeDto(final Employee employee) {
        Preconditions.checkNotNull(employee);
        return new EmployeeDto(employee.getId(), employee.getFirstname(), employee.getLastname());
    }

    @Override
    public List<EmployeeDto> mapToEmployeeDto(final List<Employee> employees) {
        Preconditions.checkNotNull(employees);
        return employees.stream()
                .map(this::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public Employee mapToEmployee(final EmployeeDto employeeDto) {
        Preconditions.checkNotNull(employeeDto);
        return new Employee(employeeDto.getId(), employeeDto.getFirstname(), employeeDto.getLastname());
    }

    @Override
    public List<Employee> mapToEmployee(final List<EmployeeDto> employeeDtos) {
        Preconditions.checkNotNull(employeeDtos);
        return employeeDtos.stream()
                .map(this::mapToEmployee)
                .collect(Collectors.toList());
    }
}
