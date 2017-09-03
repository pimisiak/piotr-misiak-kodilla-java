package com.kodilla.good.patterns.challenges.flight;

import java.time.LocalDateTime;

interface Flight {
    LocalDateTime getDepartureTime();
    LocalDateTime getArrivalTime();
    Airport getDepartureAirport();
    Airport getArrivalAirport();
}
