package com.kodilla.good.patterns.challenges.flight;

import java.util.Set;

interface FlightSearchService {
    Set<Flight> findAllFlightsToCity(final FlightSearchRequirements flightSearchRequirements);
    Set<Flight> findAllFlightsFromCity(final FlightSearchRequirements flightSearchRequirements);
    Set<Flight> findAllFlightsThroughCity(final FlightSearchRequirements flightSearchRequirements);
}
