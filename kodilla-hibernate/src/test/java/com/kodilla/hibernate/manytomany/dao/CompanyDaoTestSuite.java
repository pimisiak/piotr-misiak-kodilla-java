package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;
    private Company softwareMachine;
    private Company dataMaesters;
    private Company greyMatter;

    @Before
    public void beforeTests() {
        softwareMachine = new Company("Software Machine");
        dataMaesters = new Company("Data Maesters");
        greyMatter = new Company("Grey Matter");
        prepareEmployeesForCompanies();
    }

    @Test
    public void testSearchCompaniesWithFirstThreeLettersInName() {
        //Given
        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);
        //When
        final List<Company> searchedCompanies = companyDao.searchCompaniesWithFirstThreeLettersInName("sof");
        //Then
        assertThat(searchedCompanies).hasSize(1);
        //Clean up
        try {
            companyDao.delete(softwareMachine.getId());
            companyDao.delete(dataMaesters.getId());
            companyDao.delete(greyMatter.getId());
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Test
    public void testSearchEmployeesWithLastname() {
        //Given
        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);
        //When
        final List<Employee> searchedEmployees = employeeDao.searchEmployeesWithLastname("Kovalsky");
        //Then
        assertThat(searchedEmployees).hasSize(1);
        //Clean Up
        try {
            companyDao.delete(softwareMachine.getId());
            companyDao.delete(dataMaesters.getId());
            companyDao.delete(greyMatter.getId());
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Test
    public void testSaveManyToMany() {
        //Given
        //companies
        //When
        companyDao.save(softwareMachine);
        final int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        final int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        final int greyMatterId = greyMatter.getId();
        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);
        //CleanUp
        try {
            companyDao.delete(softwareMachineId);
            companyDao.delete(dataMaestersId);
            companyDao.delete(greyMatterId);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    private void prepareEmployeesForCompanies() {
        final Employee johnSmith = new Employee("John", "Smith");
        final Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        final Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);
    }
}
