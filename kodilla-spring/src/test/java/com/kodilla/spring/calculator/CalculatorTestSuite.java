package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalculatorTestSuite {
    @Test
    public void testAdd() {
        //Given
        final ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        final Calculator calculator = context.getBean(Calculator.class);
        //When
        final double result = calculator.add(3.5, 2.7);
        //Then
        Assert.assertEquals(6.2, result, 0.01);
    }

    @Test
    public void testMultiply() {
        //Given
        final ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        final Calculator calculator = context.getBean(Calculator.class);
        //When
        final double result = calculator.multiply(3.5, 2.7);
        //Then
        Assert.assertEquals(9.45, result, 0.01);
    }

    @Test
    public void testDivide() {
        //Given
        final ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        final Calculator calculator = context.getBean(Calculator.class);
        //When
        final double result = calculator.divide(3.5, 2.7);
        //Then
        Assert.assertEquals(1.3, result, 0.01);
    }

    @Test
    public void testSubtract() {
        //Given
        final ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        final Calculator calculator = context.getBean(Calculator.class);
        //When
        final double result = calculator.subtract(3.5, 2.7);
        //Then
        Assert.assertEquals(0.8, result, 0.01);
    }
}
