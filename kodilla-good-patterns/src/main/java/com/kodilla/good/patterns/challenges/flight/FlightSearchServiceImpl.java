package com.kodilla.good.patterns.challenges.flight;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

final class FlightSearchServiceImpl implements FlightSearchService {
    private final FlightBoard flightBoard;

    FlightSearchServiceImpl(final FlightBoard flightBoard) {
        this.flightBoard = flightBoard;
    }

    @Override
    public Set<Flight> findAllFlightsToCity(final FlightSearchRequest flightSearchRequest) {
        final Airport arrivalAirport = flightSearchRequest.getAirport();
        return flightBoard.getFlights().stream()
                .filter(flight -> flight.getArrivalAirport().equals(arrivalAirport))
                .filter(flight -> flight.getDepartureTime().isAfter(LocalDateTime.now()))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Flight> findAllFlightsFromCity(final FlightSearchRequest flightSearchRequest) {
        final Airport departureAirport = flightSearchRequest.getAirport();
        return flightBoard.getFlights().stream()
                .filter(flight -> flight.getDepartureAirport().equals(departureAirport))
                .filter(flight -> flight.getDepartureTime().isAfter(LocalDateTime.now()))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Flight> findAllFlightsThroughCity(final FlightSearchRequest flightSearchRequest) {
        final Airport airport = flightSearchRequest.getAirport();

        final LocalDateTime minArrivalTime = flightBoard.getFlights().stream()
                .filter(flight -> flight.getArrivalAirport().equals(airport))
                .filter(flight -> flight.getDepartureTime().isAfter(LocalDateTime.now()))
                .map(Flight::getArrivalTime)
                .min(LocalDateTime::compareTo)
                .orElseGet(LocalDateTime::now);
        final LocalDateTime maxDepartureTime = flightBoard.getFlights().stream()
                .filter(flight -> flight.getDepartureAirport().equals(airport))
                .filter(flight -> flight.getDepartureTime().isAfter(LocalDateTime.now()))
                .map(Flight::getArrivalTime)
                .max(LocalDateTime::compareTo)
                .orElseGet(LocalDateTime::now);

        final Set<Flight> flightsToCity = flightBoard.getFlights().stream()
                .filter(flight -> flight.getArrivalAirport().equals(airport))
                .filter(flight -> flight.getDepartureTime().isAfter(LocalDateTime.now()))
                .filter(flight -> flight.getArrivalTime().isBefore(maxDepartureTime))
                .collect(Collectors.toSet());
        final Set<Flight> flightsFromCity = flightBoard.getFlights().stream()
                .filter(flight -> flight.getDepartureAirport().equals(airport))
                .filter(flight -> flight.getDepartureTime().isAfter(LocalDateTime.now()))
                .filter(flight -> flight.getDepartureTime().isAfter(minArrivalTime))
                .collect(Collectors.toSet());

        flightsToCity.addAll(flightsFromCity);
        return Collections.unmodifiableSet(flightsToCity);
    }
}
