package com.kodilla.good.patterns.challenges.flight;

import java.time.LocalDateTime;

final class FlightImpl implements Flight {
    private final int id;
    private final Airport departureAirport;
    private final Airport arrivalAirport;
    private final LocalDateTime departureTime;
    private final LocalDateTime arrivalTime;

    private FlightImpl(final Builder builder) {
        this.id = builder.id;
        this.departureAirport = builder.departureAirport;
        this.arrivalAirport = builder.arrivalAirport;
        this.departureTime = builder.departureTime;
        this.arrivalTime = builder.arrivalTime;
    }

    @Override
    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    @Override
    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public Airport getDepartureAirport() {
        return departureAirport;
    }

    @Override
    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final FlightImpl flight = (FlightImpl) o;
        return id == flight.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Flight{" + "id=" + id + ", departureAirport=" + departureAirport + ", arrivalAirport=" + arrivalAirport
                + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + '}';
    }

    static class Builder {
        private final int id;
        private Airport departureAirport;
        private Airport arrivalAirport;
        private LocalDateTime departureTime;
        private LocalDateTime arrivalTime;

        Builder(final int id) {
            this.id = id;
        }

        Builder departureAirport(final Airport departureAirport) {
            this.departureAirport = departureAirport;
            return this;
        }

        Builder arrivalAirport(final Airport arrivalAirport) {
            this.arrivalAirport = arrivalAirport;
            return this;
        }

        Builder departureTime(final LocalDateTime departureTime) {
            this.departureTime = departureTime;
            return this;
        }

        Builder arrivalTime(final LocalDateTime arrivalTime) {
            this.arrivalTime = arrivalTime;
            return this;
        }

        FlightImpl build() {
            return new FlightImpl(this);
        }
    }
}
