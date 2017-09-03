package com.kodilla.good.patterns.challenges.flight;

final class FlightSearchRequirements {
    private final Airport airport;

    FlightSearchRequirements(final Airport airport) {
        this.airport = airport;
    }

    Airport getAirport() {
        return airport;
    }
}
