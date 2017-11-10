package com.kodilla.patterns2.aop.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    private Calculator calculator;
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorTestSuite.class);

    @Test
    public void testAdd() {
        //Given
        //When
        final double result = calculator.add(10, 15);
        //Then
        LOGGER.info("Testing add method");
        assertEquals(25, result, 0);
    }

    @Test
    public void testSubtract() {
        //Given
        //When
        final double result = calculator.subtract(10, 15);
        //Then
        LOGGER.info("Testing subtract method");
        assertEquals(-5, result, 0);
    }
    @Test
    public void testMultiply() {
        //Given
        //When
        final double result = calculator.multiply(10, 15);
        //Then
        LOGGER.info("Testing multiply method");
        assertEquals(150, result, 0);
    }
    @Test
    public void testDivide() {
        //Given
        //When
        final double result = calculator.divide(15, 5);
        //Then
        LOGGER.info("Testing divide method");
        assertEquals(3, result, 0);
    }

    @Test
    public void testFactorial() {
        //Given
        //When
        final BigDecimal result = calculator.factorial(new BigDecimal("3"));
        //Then
        LOGGER.info("Testing factorial method");
        assertEquals(new BigDecimal("6"), result);
    }
}
