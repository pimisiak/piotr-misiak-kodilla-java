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
        final Flight flightWAWtoUnknown = new Flight("WAW", "XXX");
        //When
        flightBoard.findFlight(flightWAWtoUnknown);
        //Then
        //exception RouteNotFoundException should be thrown
    }

    @Test
    public void testFindFlight() throws RouteNotFoundException {
        //Given
        final Flight flightWAWtoJFK = new Flight("WAW", "JFK");
        final Flight flightWAWtoNRT = new Flight("WAW", "NRT");
        //When
        final boolean resultWAWtoJFK = flightBoard.findFlight(flightWAWtoJFK);
        final boolean resultWAWtoNRT = flightBoard.findFlight(flightWAWtoNRT);
        //Then
        Assert.assertFalse(resultWAWtoJFK);
        Assert.assertTrue(resultWAWtoNRT);
    }
}
