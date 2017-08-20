package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

final class FlightBoard {
    void findFlight(final Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airports = checkAirports();
        long num = airports.entrySet().stream()
                .filter(es -> es.getKey().equals(flight.getArrivalAirport()) || es.getKey().equals(flight.getDepartureAirport()))
                .filter(Map.Entry::getValue)
                .count();
        if (num == 2) {
            System.out.println("Flight from " + flight.getDepartureAirport() + " to " + flight.getArrivalAirport() + " has been found.");
            return;
        }
        throw new RouteNotFoundException("Flight from " + flight.getDepartureAirport() + " to " + flight.getArrivalAirport() + " is not available.");
    }

    private Map<String, Boolean> checkAirports() {
        Map<String, Boolean> airports = new HashMap<>();
        airports.put("ATL", true);
        airports.put("DXB", true);
        airports.put("LGW", false);
        airports.put("NRT", false);
        airports.put("WAW", true);
        return airports;
    }
}
