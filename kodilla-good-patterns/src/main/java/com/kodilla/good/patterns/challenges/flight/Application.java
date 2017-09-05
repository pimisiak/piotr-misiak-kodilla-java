package com.kodilla.good.patterns.challenges.flight;

import java.time.LocalDateTime;

final class Application {
    public static void main(final String[] args) {
        final Airport wawAirport = new Airport("WAW", "Warsaw Chopin Airport");
        final Airport krkAirport = new Airport("KRK", "John Paul II International Airport Kraków–Balice");
        final Airport gdnAirport = new Airport("GDN", "Gdańsk Lech Wałęsa Airport");

        final Flight flightWawToGdn1 = new FlightImpl.Builder(1)
                .departureAirport(wawAirport)
                .arrivalAirport(krkAirport)
                .departureTime(LocalDateTime.of(2017, 9, 2, 12, 25))
                .arrivalTime(LocalDateTime.of(2017, 9, 2, 14, 35))
                .build();
        final Flight flightWawToKrK2 = new FlightImpl.Builder(2)
                .departureAirport(wawAirport)
                .arrivalAirport(krkAirport)
                .departureTime(LocalDateTime.of(2017, 9, 14, 12, 25))
                .arrivalTime(LocalDateTime.of(2017, 9, 14, 14, 35))
                .build();
        final Flight flightWawToGdn3 = new FlightImpl.Builder(3)
                .departureAirport(wawAirport)
                .arrivalAirport(gdnAirport)
                .departureTime(LocalDateTime.of(2017, 9, 27, 23, 25))
                .arrivalTime(LocalDateTime.of(2017, 9, 28, 1, 35))
                .build();

        final Flight flightKrkToGdn4 = new FlightImpl.Builder(4)
                .departureAirport(krkAirport)
                .arrivalAirport(gdnAirport)
                .departureTime(LocalDateTime.of(2017, 9, 14, 11, 25))
                .arrivalTime(LocalDateTime.of(2017, 9, 14, 13, 35))
                .build();
        final Flight flightKrkToGdn5 = new FlightImpl.Builder(5)
                .departureAirport(krkAirport)
                .arrivalAirport(gdnAirport)
                .departureTime(LocalDateTime.of(2017, 9, 14, 13, 25))
                .arrivalTime(LocalDateTime.of(2017, 9, 14, 15, 35))
                .build();
        final Flight flightKrkToGdn6 = new FlightImpl.Builder(6)
                .departureAirport(krkAirport)
                .arrivalAirport(gdnAirport)
                .departureTime(LocalDateTime.of(2017, 9, 14, 17, 25))
                .arrivalTime(LocalDateTime.of(2017, 9, 14, 19, 35))
                .build();

        final FlightBoard flightBoard = new FlightBoardImpl();
        flightBoard.addFlight(flightWawToGdn1);
        flightBoard.addFlight(flightWawToKrK2);
        flightBoard.addFlight(flightWawToGdn3);
        flightBoard.addFlight(flightKrkToGdn4);
        flightBoard.addFlight(flightKrkToGdn5);
        flightBoard.addFlight(flightKrkToGdn6);

        final FlightSearchService flightSearchService = new FlightSearchServiceImpl(flightBoard);
        System.out.printf("==== Flights from %s ====%n", wawAirport);
        flightSearchService.findAllFlightsFromCity(new FlightSearchRequest(wawAirport)).forEach(System.out::println);
        System.out.printf("==== Flights to %s ====%n", gdnAirport);
        flightSearchService.findAllFlightsToCity(new FlightSearchRequest(gdnAirport)).forEach(System.out::println);
        System.out.printf("==== Flights through %s ====%n", krkAirport);
        flightSearchService.findAllFlightsThroughCity(new FlightSearchRequest(krkAirport)).forEach(System.out::println);
    }
}
