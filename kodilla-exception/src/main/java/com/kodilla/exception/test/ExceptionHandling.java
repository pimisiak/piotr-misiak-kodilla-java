package com.kodilla.exception.test;

class ExceptionHandling {
    /**
     * Exception handling example.
     *
     * @param args arguments of main
     */
    public static void main(final String[] args) {
        final SecondChallenge secondChallenge = new SecondChallenge();
        String result = "Not done";
        try {
            result = secondChallenge.probablyWillThrowException(2, 1);
        } catch (Exception e) {
            System.out.println("Error in method probablyWillThrowException: " + e);
        } finally {
            System.out.println("Result: " + result);
        }
    }
}
