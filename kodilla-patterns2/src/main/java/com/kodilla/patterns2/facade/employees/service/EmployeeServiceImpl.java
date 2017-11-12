package com.kodilla.patterns2.facade.employees.service;

import com.kodilla.patterns2.facade.employees.dao.EmployeeDao;
import com.kodilla.patterns2.facade.employees.dto.EmployeeDto;
import com.kodilla.patterns2.facade.employees.mapper.EmployeeMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;
    private EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(final EmployeeDao employeeDao, final EmployeeMapper employeeMapper) {
        this.employeeDao = employeeDao;
        this.employeeMapper = employeeMapper;
    }

    public List<EmployeeDto> findByName(final String name) {
        return employeeMapper.mapToEmployeeDto(employeeDao.searchByName(name));
    }

    public EmployeeDto save(final EmployeeDto companyDto) {
        return employeeMapper.mapToEmployeeDto(employeeDao.save(employeeMapper.mapToEmployee(companyDto)));
    }
}
