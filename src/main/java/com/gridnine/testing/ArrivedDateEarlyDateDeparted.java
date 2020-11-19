package com.gridnine.testing;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class ArrivedDateEarlyDateDeparted implements FlightFilterInterface {
    MyZoneId myZoneId = new MyZoneId();
    private List<Flight> earlyDate = new ArrayList<>();
    private long miliDepart;
    private long miliArrived;

    @Override
    public List<Flight> doFilter(List<Flight> flights) {
        for (Flight flight : flights) {
            if (flight.getSegments().size() > 1) {
                for (Segment segment : flight.getSegments()) {
                    miliDepart = myZoneId.zoneId(segment.getDepartureDate());
                    miliArrived = myZoneId.zoneId(segment.getArrivalDate());
                    if (miliArrived < miliDepart) {
                        earlyDate.add(flight);
                    }
                }
            } else {
                miliDepart = myZoneId.zoneId(flight.getSegments().get(0).getDepartureDate());
                miliArrived = myZoneId.zoneId(flight.getSegments().get(0).getArrivalDate());
                if (miliArrived < miliDepart) {
                    earlyDate.add(flight);
                }
            }
        }
        return earlyDate;
    }
}
