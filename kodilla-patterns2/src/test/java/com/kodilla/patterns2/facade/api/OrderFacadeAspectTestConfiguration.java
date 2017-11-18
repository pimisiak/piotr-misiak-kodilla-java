package com.kodilla.patterns2.facade.api;

import com.kodilla.patterns2.facade.employees.dao.CompanyDao;
import com.kodilla.patterns2.facade.employees.dao.EmployeeDao;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.kodilla.patterns2.facade")
public class OrderFacadeAspectTestConfiguration {
    @Primary
    @Bean
    public OrderFacadeAspectLogger getOrderFacadeAspectLogger() {
        return Mockito.mock(OrderFacadeAspectLogger.class);
    }

    @Bean
    public CompanyDao getCompanyDao() {
        return Mockito.mock(CompanyDao.class);
    }

    @Bean
    public EmployeeDao getEmployeeDao() {
        return Mockito.mock(EmployeeDao.class);
    }
}
