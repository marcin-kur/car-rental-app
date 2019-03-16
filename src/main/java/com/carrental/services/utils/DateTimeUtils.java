package com.carrental.services.utils;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeUtils {
    public final static ZoneId GMT_ZONE = ZoneId.of("GMT");

    public ZonedDateTime getNowInGMT() {
        return Instant.now().atZone(GMT_ZONE);
    }
}
