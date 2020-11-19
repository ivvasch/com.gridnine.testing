package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DepartureBeforeCurrentTime implements DoFilterInterface {
    List<Flight> current = new ArrayList<>();
    Date date = new Date();
    long miliCurrent = date.getTime();
    long miliDepart;
    LocalDateTime localDateTime;

    @Override
    public List<Flight> doFilter(List<Flight> flights) {
        for (Flight flight : flights) {
            localDateTime = flight.getSegments().get(0).getDepartureDate();
            ZoneId id = ZoneId.systemDefault();
            ZonedDateTime zdt = ZonedDateTime.of(localDateTime, id);
            miliDepart = zdt.toInstant().toEpochMilli();
            if ((miliCurrent - miliDepart) > 0) {
                current.add(flight);
            }
        }
        return current;
    }
}
