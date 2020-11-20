package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class TimeOnEarthOver2HoursFilterImpl implements FlightFilterInterface {
    LocalZoneId localZoneId = new LocalZoneId();
    private List<Flight> twoHours = new ArrayList<>();
    private long miliDepart;
    private long miliArrived;

    @Override
    public List<Flight> doFilter(List<Flight> flights) {
        for (Flight flight : flights) {
            if (flight.getSegments().size() > 1) {
                long allTime = 0;
                for (int i = 0; i < flight.getSegments().size() - 1; i++) {
                    miliDepart = localZoneId.zoneId(flight.getSegments().get(i + 1).getDepartureDate());
                    miliArrived = localZoneId.zoneId(flight.getSegments().get(i).getArrivalDate());
                    allTime = allTime + (miliDepart - miliArrived);
                    if ((allTime / 7200000) <= 1) {
                        twoHours.add(flight);
                    }
                }
            }
        }
        return twoHours;
    }
}
