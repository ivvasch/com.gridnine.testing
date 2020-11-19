package com.gridnine.testing;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ArrivedDateEarlyDateDepartedTest {

    @Test
    public void doFilter() {
        List<Flight> flightList = FlightBuilder.createFlights();
        FlightFilterInterface filter = new ArrivedDateEarlyDateDeparted();
        List<Flight> flights = filter.doFilter(flightList);

        Assert.assertEquals(1, flights.size());
    }
}