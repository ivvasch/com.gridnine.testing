package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class MyZoneId {
    private LocalDateTime localDateTime;

    public long zoneId(LocalDateTime localDateTime) {
        ZoneId id = ZoneId.systemDefault();
        ZonedDateTime zdt = ZonedDateTime.of(localDateTime, id);
        return zdt.toInstant().toEpochMilli();
    }
}
