package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

final class FlightBoard {
    private final Map<String, Boolean> airports = new HashMap<>();

    boolean findFlight(final Flight flight) throws RouteNotFoundException {
        if (airports.containsKey(flight.getArrivalAirport()) && airports.containsKey(flight.getDepartureAirport())) {
            return airports.get(flight.getArrivalAirport()) && airports.get(flight.getDepartureAirport());
        }
        throw new RouteNotFoundException("Error: Airport missing.");
    }

    void addAirport(final String name, final boolean available) {
        airports.put(name, available);
    }
}
