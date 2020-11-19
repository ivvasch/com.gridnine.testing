package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    List<Flight> list = FlightBuilder.createFlights();
        for (Flight flight : list) {
            System.out.println(flight);
            long lclminute = 0;
            for (Segment segment : flight.getSegments())
                lclminute = segment.getArrivalDate().getLong(ChronoField.MINUTE_OF_DAY);
                System.out.println(lclminute);
        }

    }
}
