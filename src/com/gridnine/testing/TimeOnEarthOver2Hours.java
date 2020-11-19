package com.gridnine.testing;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class TimeOnEarthOver2Hours implements DoFilterInterface {
    List<Flight> twoHours = new ArrayList<>();
    long miliDepart;
    long miliArrived;
    @Override
    public List<Flight> doFilter(List<Flight> flights) {
        for (Flight flight : flights) {
            if (flight.getSegments().size() > 1) {
                long allTime = 0;
                for (int i = 0; i < flight.getSegments().size()-1; i++) {

                    ZoneId id = ZoneId.systemDefault();
                    ZonedDateTime zdt = ZonedDateTime.of(flight.getSegments().get(i+1).getDepartureDate(), id);
                    miliDepart = zdt.toInstant().toEpochMilli();
                    ZonedDateTime zdt2 = ZonedDateTime.of(flight.getSegments().get(i).getArrivalDate(), id);
                    miliArrived = zdt2.toInstant().toEpochMilli();
                    allTime = allTime + (miliDepart - miliArrived);
                    if ((allTime / 7200000) >= 1) {
                        twoHours.add(flight);
                    }
                }
            }
        }
        return twoHours;
    }
}
