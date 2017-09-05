package com.kodilla.good.patterns.challenges.flight;

final class FlightSearchRequest {
    private final Airport airport;

    FlightSearchRequest(final Airport airport) {
        this.airport = airport;
    }

    Airport getAirport() {
        return airport;
    }
}
