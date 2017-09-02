package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    private Calculator calculator;

    @Test
    public void testAdd() {
        //Given
        //calculator
        //When
        final double result = calculator.add(3.5, 2.7);
        //Then
        Assert.assertEquals(6.2, result, 0.01);
    }

    @Test
    public void testMultiply() {
        //Given
        //calculator
        //When
        final double result = calculator.multiply(3.5, 2.7);
        //Then
        Assert.assertEquals(9.45, result, 0.01);
    }

    @Test
    public void testDivide() {
        //Given
        //calculator
        //When
        final double result = calculator.divide(3.5, 2.7);
        //Then
        Assert.assertEquals(1.3, result, 0.01);
    }

    @Test
    public void testSubtract() {
        //Given
        //calculator
        //When
        final double result = calculator.subtract(3.5, 2.7);
        //Then
        Assert.assertEquals(0.8, result, 0.01);
    }
}
