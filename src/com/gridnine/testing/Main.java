package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    List<Flight> list = FlightBuilder.createFlights();
        DepartureBeforeCurrentTime departureBeforeCurrentTime = new DepartureBeforeCurrentTime();
        System.out.println(departureBeforeCurrentTime.doFilter(list));

        ArrivedDateEarlyDateDeparted arrivedDateEarlyDateDeparted = new ArrivedDateEarlyDateDeparted();
        System.out.println(arrivedDateEarlyDateDeparted.doFilter(list));

        TimeOnEarthOver2Hours time = new TimeOnEarthOver2Hours();
        System.out.println(time.doFilter(list));

    }
}
