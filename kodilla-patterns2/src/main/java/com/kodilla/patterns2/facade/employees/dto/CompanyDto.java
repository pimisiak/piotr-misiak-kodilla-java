package com.kodilla.patterns2.facade.employees.dto;

public class CompanyDto {
    private final int id;
    private final String name;

    public CompanyDto(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
