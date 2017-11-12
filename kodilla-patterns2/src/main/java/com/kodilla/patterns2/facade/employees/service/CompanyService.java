package com.kodilla.patterns2.facade.employees.service;

import com.kodilla.patterns2.facade.employees.dto.CompanyDto;
import java.util.List;

public interface CompanyService {
    List<CompanyDto> findByName(final String name);
    CompanyDto save(final CompanyDto companyDto);
}
