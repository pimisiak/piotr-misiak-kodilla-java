package com.kodilla.exception.test;

final class Flight {
    private final String departureAirport;
    private final String arrivalAirport;

    Flight(final String departureAirport, final String arrivalAirport) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    String getDepartureAirport() {
        return departureAirport;
    }

    String getArrivalAirport() {
        return arrivalAirport;
    }
}
