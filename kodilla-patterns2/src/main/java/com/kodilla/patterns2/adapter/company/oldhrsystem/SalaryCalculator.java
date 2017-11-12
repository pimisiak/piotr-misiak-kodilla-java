package com.kodilla.patterns2.adapter.company.oldhrsystem;

public interface SalaryCalculator {
    double totalSalary(final String[][] workers, final double[] salaries);
}
