package com.gridnine.testing;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TimeOnEarthOver2HoursFilterImplTest {

    @Test
    public void doFilter() {
        List<Flight> flightList = FlightBuilder.createFlights();
        FlightFilterInterface filter = new TimeOnEarthOver2HoursFilterImpl();
        List<Flight> flights = filter.doFilter(flightList);

        Assert.assertEquals(4, flights.size());
    }
}