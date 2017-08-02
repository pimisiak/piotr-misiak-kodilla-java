package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        String result = simpleUser.getUsername();
        System.out.println("Test User");
        if (result.equals("theForumUser")) {
            System.out.println("Test ok");
        } else {
            System.out.println("Error!");
        }

        Calculator calculator = new Calculator();
        int a = 123;
        int b = 23;
        System.out.println("Test Calculator Add");
        if (calculator.add(a, b) == 146) {
            System.out.println("Test ok");
        } else {
            System.out.println("Error!");
        }
        System.out.println("Test Calculator Substract");
        if (calculator.substract(a, b) == 100) {
            System.out.println("Test ok");
        } else {
            System.out.println("Error!");
        }
    }
}
