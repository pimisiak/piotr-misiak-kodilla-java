package com.kodilla.exception.challenge;

public class FirstChallenge {

    private double divide(final double a, final double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Dividing by 0 not allowed.");
        }
        return a / b;
    }

    /**
     * Divides two numbers.
     *
     * @param args arguments of main
     */
    public static void main(final String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        try {
            double result = firstChallenge.divide(3, 0);
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Error running divide method: " + e.getLocalizedMessage());
        }
    }
}