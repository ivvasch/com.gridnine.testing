package com.gridnine.testing;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ArrivedDateEarlyDateDepartedTest {

    @Test
    public void doFilter() {
        List<Flight> flightList = FlightBuilder.createFlights();
        FlightFilterInterface filter = new ArrivedDateEarlyDateDepartedFilterImpl();
        List<Flight> flights = filter.doFilter(flightList);

        Assert.assertEquals(5, flights.size());
    }
}