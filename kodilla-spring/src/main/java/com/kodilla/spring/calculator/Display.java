package com.kodilla.spring.calculator;

import org.springframework.stereotype.Component;

@Component
class Display {
    void displayValue(final double val) {
        System.out.println(val);
    }
}
