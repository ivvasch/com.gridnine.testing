package com.gridnine.testing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrivedDateEarlyDateDepartedFilterImpl implements FlightFilterInterface {
    LocalZoneId localZoneId = new LocalZoneId();
    private long miliDepart;
    private long miliArrived;

    @Override
    public List<Flight> doFilter(List<Flight> flights) {
        List<Flight> filteredList = new ArrayList<>(flights);
        Iterator iterator = filteredList.iterator();
        while (iterator.hasNext()) {
            Flight flight = (Flight) iterator.next();
            boolean isIncorrect = false;
            for (Segment segment : flight.getSegments()) {
                miliDepart = localZoneId.zoneId(segment.getDepartureDate());
                miliArrived = localZoneId.zoneId(segment.getArrivalDate());
                if (miliArrived < miliDepart) {
                    isIncorrect = true;
                }
            }
            if (isIncorrect) {
                iterator.remove();
            }
        }
        return filteredList;
    }

}
