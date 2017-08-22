package com.kodilla.exception.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlightBoardTestSuite {
    private FlightBoard flightBoard;

    @Before
    public void beforeTest() {
        flightBoard = new FlightBoard();
        flightBoard.addAirport("WAW", true);
        flightBoard.addAirport("NRT", true);
        flightBoard.addAirport("JFK", false);
        flightBoard.addAirport("CIA", true);
        flightBoard.addAirport("GVA", false);
    }

    @Test(expected = RouteNotFoundException.class)
    public void testFindFlightException() throws RouteNotFoundException {
        //Given
        final Flight flight = new Flight("WAW", "XXX");
        //When
        flightBoard.findFlight(flight);
        //Then
        //exception RouteNotFoundException should be thrown
    }

    @Test
    public void testFindFlight() throws RouteNotFoundException {
        //Given
        final Flight flight0 = new Flight("WAW", "JFK");
        final Flight flight1 = new Flight("WAW", "NRT");
        //When
        final boolean result0 = flightBoard.findFlight(flight0);
        final boolean result1 = flightBoard.findFlight(flight1);
        //Then
        Assert.assertFalse(result0);
        Assert.assertTrue(result1);
    }
}
