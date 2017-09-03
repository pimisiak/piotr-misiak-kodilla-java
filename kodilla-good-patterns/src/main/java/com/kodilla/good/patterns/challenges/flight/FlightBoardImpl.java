package com.kodilla.good.patterns.challenges.flight;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class FlightBoardImpl implements FlightBoard {
    private final Set<Flight> flights = new HashSet<>();

    public void addFlight(final Flight flight) {
        flights.add(flight);
    }

    public Set<Flight> getFlights() {
        return Collections.unmodifiableSet(flights);
    }
}
