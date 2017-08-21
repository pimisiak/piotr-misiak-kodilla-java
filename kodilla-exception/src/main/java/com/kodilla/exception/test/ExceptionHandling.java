package com.kodilla.exception.test;

class ExceptionHandling {
    /**
     * Exception handling example.
     *
     * @param args arguments of main
     */
    public static void main(final String[] args) {
        //SecondChallenge exception assignment
        final SecondChallenge secondChallenge = new SecondChallenge();
        String result = "Not done";
        try {
            result = secondChallenge.probablyWillThrowException(2, 1);
        } catch (Exception e) {
            System.out.println("Error in method probablyWillThrowException: " + e);
        } finally {
            System.out.println("Result: " + result);
        }

        //Flight exception assignment
        final FlightBoard flightBoard = new FlightBoard();
        final Flight flight0 = new Flight("WAW", "ATL");
        final Flight flight1 = new Flight("WAW", "NRT");
        final Flight flight2 = new Flight("XXX", "YYY");
        final Flight flight3 = new Flight("DXB", "WAW");
        try {
            flightBoard.findFlight(flight0);
        } catch (RouteNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            flightBoard.findFlight(flight1);
        } catch (RouteNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            flightBoard.findFlight(flight2);
        } catch (RouteNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            flightBoard.findFlight(flight3);
        } catch (RouteNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
