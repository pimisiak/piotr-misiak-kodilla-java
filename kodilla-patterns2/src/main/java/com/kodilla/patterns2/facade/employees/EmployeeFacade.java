package com.kodilla.patterns2.facade.employees;

import com.kodilla.patterns2.facade.employees.dto.CompanyDto;
import com.kodilla.patterns2.facade.employees.dto.EmployeeDto;
import com.kodilla.patterns2.facade.employees.service.CompanyService;
import com.kodilla.patterns2.facade.employees.service.EmployeeService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class EmployeeFacade {
    private final CompanyService companyService;
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeFacade(final CompanyService companyService, final EmployeeService employeeService) {
        this.companyService = companyService;
        this.employeeService = employeeService;
    }

    public List<EmployeeDto> searchEmployeesByName(final String name) {
        return employeeService.findByName(name);
    }

    public List<CompanyDto> searchCompaniesByName(final String name) {
        return companyService.findByName(name);
    }
}
