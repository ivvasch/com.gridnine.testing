package com.gridnine.testing;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class ArrivedDateEarlyDateDeparted implements DoFilterInterface {
    private List<Flight> earlyDate = new ArrayList<>();
    private long miliDepart;
    private long miliArrived;

    @Override
    public List<Flight> doFilter(List<Flight> flights) {
        for (Flight flight : flights) {
            if (flight.getSegments().size() > 1) {
                for (Segment segment : flight.getSegments()) {
                    ZoneId id = ZoneId.systemDefault();
                    ZonedDateTime zdt = ZonedDateTime.of(segment.getDepartureDate(), id);
                    miliDepart = zdt.toInstant().toEpochMilli();
                    ZonedDateTime zdt2 = ZonedDateTime.of(segment.getArrivalDate(), id);
                    miliArrived = zdt2.toInstant().toEpochMilli();
                    if (miliArrived < miliDepart) {
                        earlyDate.add(flight);
                    }
                }
            } else {
                ZoneId id = ZoneId.systemDefault();
                ZonedDateTime zdt = ZonedDateTime.of(flight.getSegments().get(0).getDepartureDate(), id);
                miliDepart = zdt.toInstant().toEpochMilli();
                ZonedDateTime zdt2 = ZonedDateTime.of(flight.getSegments().get(0).getArrivalDate(), id);
                miliArrived = zdt2.toInstant().toEpochMilli();
                if (miliArrived < miliDepart) {
                    earlyDate.add(flight);
                }
            }
        }
        return earlyDate;
    }
}
