package com.kodilla.patterns2.facade.employees;

import com.kodilla.patterns2.facade.employees.dto.CompanyDto;
import com.kodilla.patterns2.facade.employees.dto.EmployeeDto;
import com.kodilla.patterns2.facade.employees.service.CompanyService;
import com.kodilla.patterns2.facade.employees.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(
        locations = "classpath:application.properties"
)
public class EmployeeFacadeTestSuite {
    @Autowired
    private EmployeeFacade employeeFacade;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CompanyService companyService;

    @Test
    public void testSearchEmployeesByName() {
        //Given
        prepareTestEmployees();
        //When
        final List<EmployeeDto> employees = employeeFacade.searchEmployeesByName("%Kowalski%");
        //Then
        assertThat(employees)
                .hasSize(1)
                .extracting("firstname", "lastname")
                .contains(tuple("Jan", "Kowalski"));
    }

    private void prepareTestEmployees() {
        employeeService.save(new EmployeeDto(1, "Jan", "Kowalski"));
        employeeService.save(new EmployeeDto(2, "John", "Smith"));
        employeeService.save(new EmployeeDto(3, "Ivone", "Nowicki"));
    }

    @Test
    public void testSearchCompaniesByName() {
        //Given
        prepareTestCompanies();
        //When
        final List<CompanyDto> companyDtos = employeeFacade.searchCompaniesByName("%oo%");
        //Then
        assertThat(companyDtos)
                .hasSize(2)
                .extracting("name")
                .contains("Facebook", "Google");
    }

    private void prepareTestCompanies() {
        companyService.save(new CompanyDto(1, "Apple"));
        companyService.save(new CompanyDto(2, "Google"));
        companyService.save(new CompanyDto(3, "Facebook"));
    }
}
