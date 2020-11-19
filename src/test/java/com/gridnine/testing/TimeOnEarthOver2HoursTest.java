package com.gridnine.testing;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TimeOnEarthOver2HoursTest {

    @Test
    public void doFilter() {
        List<Flight> flightList = FlightBuilder.createFlights();
        FlightFilterInterface filter = new TimeOnEarthOver2Hours();
        List<Flight> flights = filter.doFilter(flightList);

        Assert.assertEquals(2, flights.size());
    }
}