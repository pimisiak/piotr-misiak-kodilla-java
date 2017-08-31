package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
final class Calculator {
    private final Display display;

    @Autowired
    Calculator(final Display display) {
        this.display = display;
    }

    double add(final double a, final double b) {
        final double result = a + b;
        display.displayValue(result);
        return result;
    }

    double subtract(final double a, final double b) {
        final double result = a - b;
        display.displayValue(result);
        return result;
    }

    double multiply(final double a, final double b) {
        final double result = a * b;
        display.displayValue(result);
        return result;
    }

    double divide(final double a, final double b) {
        final double result = a / b;
        display.displayValue(result);
        return result;
    }
}
