package com.kodilla.patterns2.adapter.company;

import com.kodilla.patterns2.adapter.company.oldhrsystem.Workers;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SalaryAdapterTestSuite {
    @Test
    public void testTotalSalary() {
        //Given
        final Workers workers = new Workers();
        final SalaryAdapter salaryAdapter = new SalaryAdapter();
        //When
        final double totalSalary = salaryAdapter.totalSalary(workers.getWorkers(), workers.getSalaries());
        //Then
        System.out.println(totalSalary);
        assertEquals(totalSalary, 27750, 0);
    }
}
