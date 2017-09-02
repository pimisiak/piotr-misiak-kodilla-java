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
        final double numOne = 3.5;
        final double numTwo = 2.7;
        //When
        final double result = calculator.add(numOne, numTwo);
        //Then
        Assert.assertEquals(6.2, result, 0.01);
    }

    @Test
    public void testMultiply() {
        //Given
        final double numOne = 3.5;
        final double numTwo = 2.7;
        //When
        final double result = calculator.multiply(numOne, numTwo);
        //Then
        Assert.assertEquals(9.45, result, 0.01);
    }

    @Test
    public void testDivide() {
        //Given
        final double numOne = 3.5;
        final double numTwo = 2.7;
        //When
        final double result = calculator.divide(numOne, numTwo);
        //Then
        Assert.assertEquals(1.3, result, 0.01);
    }

    @Test
    public void testSubtract() {
        //Given
        final double numOne = 3.5;
        final double numTwo = 2.7;
        //When
        final double result = calculator.subtract(numOne, numTwo);
        //Then
        Assert.assertEquals(0.8, result, 0.01);
    }
}
