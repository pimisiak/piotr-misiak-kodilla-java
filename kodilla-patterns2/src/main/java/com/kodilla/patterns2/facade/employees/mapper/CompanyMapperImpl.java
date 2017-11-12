package com.kodilla.patterns2.facade.employees.mapper;

import com.google.common.base.Preconditions;
import com.kodilla.patterns2.facade.employees.dto.CompanyDto;
import com.kodilla.patterns2.facade.employees.entity.Company;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CompanyMapperImpl implements CompanyMapper {
    @Override
    public CompanyDto mapToCompanyDto(final Company company) {
        Preconditions.checkNotNull(company);
        return new CompanyDto(company.getId(), company.getName());
    }

    @Override
    public List<CompanyDto> mapToCompanyDto(final List<Company> companies) {
        Preconditions.checkNotNull(companies);
        return companies.stream()
                .map(this::mapToCompanyDto)
                .collect(Collectors.toList());
    }

    @Override
    public Company mapToCompany(final CompanyDto companyDto) {
        Preconditions.checkNotNull(companyDto);
        return new Company(companyDto.getId(), companyDto.getName());
    }

    @Override
    public List<Company> mapToCompany(final List<CompanyDto> companyDtos) {
        Preconditions.checkNotNull(companyDtos);
        return companyDtos.stream()
                .map(this::mapToCompany)
                .collect(Collectors.toList());
    }
}
