package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DepartureBeforeCurrentTimeFilterImpl implements FlightFilterInterface {
    LocalZoneId localZoneId = new LocalZoneId();
    private List<Flight> current = new ArrayList<>();
    private Date date = new Date();
    private long miliCurrent = date.getTime();
    private long miliDepart;
    private LocalDateTime localDateTime;

    @Override
    public List<Flight> doFilter(List<Flight> flights) {
        for (Flight flight : flights) {
            miliDepart = localZoneId.zoneId(flight.getSegments().get(0).getDepartureDate());
            if ((miliCurrent - miliDepart) < 0) {
                current.add(flight);
            }
        }
        return current;
    }
}
