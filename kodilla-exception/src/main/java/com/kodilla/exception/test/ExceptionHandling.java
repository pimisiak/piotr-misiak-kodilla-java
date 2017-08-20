package com.kodilla.exception.test;

class ExceptionHandling {
    /**
     * Exception handling example.
     *
     * @param args arguments of main
     */
    public static void main(final String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            System.out.println(secondChallenge.probablyWillThrowException(2, 1));
        } catch (Exception e) {
            System.out.println("Error in method probablyWillThrowException: " + e);
        }
    }
}
