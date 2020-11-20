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

        FlightFilterInterface departureBeforeCurrentTime = new DepartureBeforeCurrentTimeFilterImpl();
        System.out.println(departureBeforeCurrentTime.doFilter(list));
        System.out.println();
        FlightFilterInterface arrivedDateEarlyDateDeparted = new ArrivedDateEarlyDateDepartedFilterImpl();
        System.out.println(arrivedDateEarlyDateDeparted.doFilter(list));
        System.out.println();
        FlightFilterInterface time = new TimeOnEarthOver2HoursFilterImpl();
        System.out.println(time.doFilter(list));

    }
}
