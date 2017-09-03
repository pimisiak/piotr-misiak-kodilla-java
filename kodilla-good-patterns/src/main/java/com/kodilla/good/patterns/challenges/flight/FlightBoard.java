package com.kodilla.good.patterns.challenges.flight;

import java.util.Set;

public interface FlightBoard {
    void addFlight(final Flight flight);
    Set<Flight> getFlights();
}
