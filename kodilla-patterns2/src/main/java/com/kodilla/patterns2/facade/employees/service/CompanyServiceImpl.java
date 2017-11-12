package com.kodilla.patterns2.facade.employees.service;

import com.kodilla.patterns2.facade.employees.dao.CompanyDao;
import com.kodilla.patterns2.facade.employees.dto.CompanyDto;
import com.kodilla.patterns2.facade.employees.mapper.CompanyMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyDao companyDao;
    private CompanyMapper companyMapper;

    @Autowired
    public CompanyServiceImpl(final CompanyDao companyDao, final CompanyMapper companyMapper) {
        this.companyDao = companyDao;
        this.companyMapper = companyMapper;
    }

    public List<CompanyDto> findByName(final String name) {
        return companyMapper.mapToCompanyDto(companyDao.searchByName(name));
    }

    public CompanyDto save(final CompanyDto companyDto) {
        return companyMapper.mapToCompanyDto(companyDao.save(companyMapper.mapToCompany(companyDto)));
    }
}
