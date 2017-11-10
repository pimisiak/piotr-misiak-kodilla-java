package com.kodilla.patterns2.aop.calculator;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy
public class Calculator {
    public double add(final double x,final double y) {
        return x + y;
    }

    public double subtract(final double x, final double y) {
        return x - y;
    }

    public double multiply(final double x, final double y) {
        return x * y;
    }

    public double divide(final double x, final double y) {
        if (y == 0) {
            throw new ArithmeticException("Divide by zero.");
        }
        return x / y;
    }

    public BigDecimal factorial(final BigDecimal n) {
        if (n.compareTo(ZERO) > 0) {
            return n.multiply(factorial(n.subtract(ONE)));
        }
        if (n.equals(ONE) || n.equals(ZERO)) {
            return ONE;
        }
        throw new ArithmeticException("Factorial argument is negative");
    }
}
