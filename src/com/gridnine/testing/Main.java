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
//        DepartureBeforeCurrentTime departureBeforeCurrentTime = new DepartureBeforeCurrentTime();
//        System.out.println(departureBeforeCurrentTime.doFilter(list));

        ArrivedDateEarlyDateDeparted arrivedDateEarlyDateDeparted = new ArrivedDateEarlyDateDeparted();
        System.out.println(arrivedDateEarlyDateDeparted.doFilter(list));


//        Date date = new Date();
//        System.out.println(date.getTime());
//        System.out.println(date);
//        for (Flight flight : list) {
//            System.out.println(flight);
//            LocalDateTime lclminute = null;
//            for (Segment segment : flight.getSegments())
//                lclminute = segment.getArrivalDate();
//            System.out.println(lclminute);
//            ZoneId id = ZoneId.systemDefault();
//            ZonedDateTime zdt = ZonedDateTime.of(lclminute, id);
//            System.out.println(zdt.toInstant().toEpochMilli());

//        }

    }
}
