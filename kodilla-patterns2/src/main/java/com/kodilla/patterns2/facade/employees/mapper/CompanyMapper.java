package com.kodilla.patterns2.facade.employees.mapper;

import com.kodilla.patterns2.facade.employees.dto.CompanyDto;
import com.kodilla.patterns2.facade.employees.entity.Company;

import java.util.List;

public interface CompanyMapper {
    CompanyDto mapToCompanyDto(final Company company);
    List<CompanyDto> mapToCompanyDto(final List<Company> companies);
    Company mapToCompany(final CompanyDto companyDto);
    List<Company> mapToCompany(final List<CompanyDto> companyDtos);

}
