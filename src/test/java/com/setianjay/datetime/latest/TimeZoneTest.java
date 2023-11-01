package com.setianjay.datetime.latest;

import org.junit.jupiter.api.Test;

import java.time.*;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * {@link ZonedDateTime} is a class that is used to create dates and times with time zone. If you use ZonedDateTime, the
 * arguments that we can send are {@link ZoneId} and {@link ZoneOffset}.
 * <br />
 * <br />
 * {@link OffsetDateTime} is a class that is used to create dates and times with time zone. If you use OffsetDateTime,
 * the argument that we can send only {@link ZoneOffset}.
 * <br />
 * <br />
 * {@link OffsetTime} is a class that is used to create times with time zone. If you use OffsetTime, the argument that
 * we can send only {@link  ZoneOffset}.
 * <br />
 * <br />
 * ---------------------------------------------------------------------------------------------------------------------
 * <br />
 * <br />
 * {@link ZoneId} is a class that is used to create time zone using its id. {@link ZoneOffset} is a class that is used to
 * create time zone using its hours or hours and minutes.
 * */
class TimeZoneTest {

    @Test
    void testGetAllTimeZoneId(){
        String[] timeZoneIds = ZoneId.getAvailableZoneIds().toArray(new String[0]);

        assertNotEquals(0, timeZoneIds.length);

        for(String timeZoneId: timeZoneIds){
            System.out.println(timeZoneId);
        }
    }

    @Test
    void testCreateTimeZoneUsingZonedDateTimeObject(){
        ZonedDateTime wibZonedDateTime = ZonedDateTime.now(); // WIB, because my time zone in operating system is WIB
        /*
        * If we use ZonedDateTime to create dates and times with time zone, the arguments we can send are ZoneId and
        * ZoneOffset
        * */
        ZonedDateTime witaZonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Makassar")); // WITA
        ZonedDateTime witZonedDateTime = ZonedDateTime.now(ZoneOffset.ofHours(9)); // WIT

        assertNotNull(wibZonedDateTime);
        assertNotNull(witaZonedDateTime);
        assertNotNull(witZonedDateTime);

        System.out.println("Date and Time in Jakarta (WIB): " + wibZonedDateTime);
        System.out.println("Date and Time in Makassar (WITA): " + witaZonedDateTime);
        System.out.println("Date and Time in Jayapura (WIT): " + witZonedDateTime);

        // To format date and time in latest api, the default format is yyyy-MM-ddTHH:mm:ss.ns+ZoneOffset[ZoneId]
//        String pattern = "dd-MM-yyyy HH:mm:ss";
//        String jakartaZonedDateTimeFormat = DateTimeFormatter.ofPattern(pattern).format(wibZonedDateTime);
//        String makassarZonedDateTimeFormat = DateTimeFormatter.ofPattern(pattern).format(witaZonedDateTime);
//        String papuaZonedDateTimeFormat = DateTimeFormatter.ofPattern(pattern).format(witZonedDateTime);

//        System.out.println("Time in Jakarta (WIB): " + jakartaZonedDateTimeFormat);
//        System.out.println("Time in Makassar (WITA): " + makassarZonedDateTimeFormat);
//        System.out.println("Time in Jayapura (WIT): " + papuaZonedDateTimeFormat);
    }

    @Test
    void testCreateTimeZoneUsingOffsetDateTimeObject(){
        OffsetDateTime wibZonedDateTime = OffsetDateTime.now(); // WIB, because my time zone in operating system is WIB

        /*
         * If we use OffsetDateTime to create dates and time with time zone, arguments that we can send only ZoneOffset.
         * */
        OffsetDateTime witaZonedDateTime = OffsetDateTime.now(ZoneOffset.ofHours(8)); // WITA
        OffsetDateTime witZonedDateTime = OffsetDateTime.now(ZoneOffset.ofHours(9)); // WIT

        assertNotNull(wibZonedDateTime);
        assertNotNull(witaZonedDateTime);
        assertNotNull(witZonedDateTime);

        System.out.println("Date and Time in Jakarta (WIB): " + wibZonedDateTime);
        System.out.println("Date and Time in Makassar (WITA): " + witaZonedDateTime);
        System.out.println("Date and Time in Jayapura (WIT): " + witZonedDateTime);

        // To format date and time in latest api, the default format is yyyy-MM-ddTHH:mm:ss.ns+ZoneOffset
//        String pattern = "dd-MM-yyyy HH:mm:ss";
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
//        String jakartaZonedDateTimeFormat = wibZonedDateTime.format(dateTimeFormatter);
//        String makassarZonedDateTimeFormat = witaZonedDateTime.format(dateTimeFormatter);
//        String papuaZonedDateTimeFormat = witZonedDateTime.format(dateTimeFormatter);
//
//        System.out.println("Time in Jakarta (WIB): " + jakartaZonedDateTimeFormat);
//        System.out.println("Time in Makassar (WITA): " + makassarZonedDateTimeFormat);
//        System.out.println("Time in Jayapura (WIT): " + papuaZonedDateTimeFormat);
    }

    @Test
    void testCreateTimeZoneUsingOffsetTimeObject(){
        OffsetTime wibZonedTime = OffsetTime.now(); // WIB, because my time zone in operating system is WIB
        OffsetTime witaZonedTime = OffsetTime.now(ZoneOffset.ofHours(8)); // WITA
        OffsetTime witZonedTime = OffsetTime.now(ZoneOffset.ofHours(9)); // WIT

        assertNotNull(wibZonedTime);
        assertNotNull(witaZonedTime);
        assertNotNull(witZonedTime);

        System.out.println("Time in Jakarta (WIB): " + wibZonedTime);
        System.out.println("Time in Makassar (WITA): " + witaZonedTime);
        System.out.println("Time in Jayapura (WIT): " + witZonedTime);

        // To format date and time in latest api, the default format is HH:mm:ss.ns+ZoneOffset
//        String pattern = "HH:mm:ss";
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
//        String jakartaZonedDateTimeFormat = wibZonedTime.format(dateTimeFormatter);
//        String makassarZonedDateTimeFormat = witaZonedTime.format(dateTimeFormatter);
//        String papuaZonedDateTimeFormat = witZonedTime.format(dateTimeFormatter);
//
//        System.out.println("Time in Jakarta (WIB): " + jakartaZonedDateTimeFormat);
//        System.out.println("Time in Makassar (WITA): " + makassarZonedDateTimeFormat);
//        System.out.println("Time in Jayapura (WIT): " + papuaZonedDateTimeFormat);
    }

    @Test
    void testChangeTimeZone(){
        ZonedDateTime wibZonedDateTime = ZonedDateTime.now();

        // changes time zone
        ZonedDateTime gmtZonedDateTimeWithSameLocal = wibZonedDateTime.withZoneSameLocal(ZoneId.of("GMT"));
        ZonedDateTime gmtZoneDateTimeWithSameInstant = wibZonedDateTime.withZoneSameInstant(ZoneId.of("GMT"));

        assertNotNull(gmtZonedDateTimeWithSameLocal);
        assertNotNull(gmtZoneDateTimeWithSameInstant);

        System.out.println("Date time in Jakarta (WIB): " + wibZonedDateTime);
        /*
         * if you change the time zone with withZoneSameLocal() method, it will only change the time zone information
         * without changing the date or time.
         *
         * if you change the time zone with withZoneSameInstant() method, it will change the date and time based on its
         * time zone.
         * */
        System.out.println("Date time in Britannia using same local (GMT): " + gmtZonedDateTimeWithSameLocal);
        System.out.println("Date time in Britannia using same instant (GMT): " + gmtZoneDateTimeWithSameInstant);
    }
}
