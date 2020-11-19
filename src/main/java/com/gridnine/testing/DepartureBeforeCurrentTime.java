package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DepartureBeforeCurrentTime implements FlightFilterInterface {
    MyZoneId myZoneId = new MyZoneId();
    private List<Flight> current = new ArrayList<>();
    private Date date = new Date();
    private long miliCurrent = date.getTime();
    private long miliDepart;
    private LocalDateTime localDateTime;

    @Override
    public List<Flight> doFilter(List<Flight> flights) {
        for (Flight flight : flights) {
            miliDepart = myZoneId.zoneId(flight.getSegments().get(0).getDepartureDate());
            if ((miliCurrent - miliDepart) > 0) {
                current.add(flight);
            }
        }
        return current;
    }
}
