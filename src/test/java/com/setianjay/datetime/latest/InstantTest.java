package com.setianjay.datetime.latest;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * {@link Instant} is a class that is used to create date and time using epoch millis or epoch second. In other words,
 * this class represents the epoch millis or epoch second of a date and time.
 * <br />
 * <br />
 * {@link Instant} class is also used to convert legacy date and time api to the latest API of date and time.
 * */
class InstantTest {

    @Test
    void testCreateDateUsingInstant(){
        Instant currentDateTime = Instant.now();

        assertNotNull(currentDateTime);

        System.out.println("Current date: " + currentDateTime);
    }

    @Test
    void testCreateSpecificDateUsingInstant(){
        Instant myBirthDateTimeFromEpochMillis = Instant.ofEpochMilli(973917327000L);
        Instant myBirthDateTimeFromEpochSeconds = Instant.ofEpochSecond(973917327); // epochSecond = millis / 1000

        assertNotNull(myBirthDateTimeFromEpochMillis);
        assertNotNull(myBirthDateTimeFromEpochSeconds);

        System.out.println("My birthday is: " + myBirthDateTimeFromEpochMillis);
        System.out.println("My birthday is: " + myBirthDateTimeFromEpochSeconds);
    }

    @Test
    void testGetElements(){
        Instant currentDateTime = Instant.now();

        assertNotNull(currentDateTime);

        System.out.println("Nanos: " + currentDateTime.getNano());
        System.out.println("Epoch seconds from date time " + currentDateTime + " is: " + currentDateTime.getEpochSecond());
        System.out.println("Epoch millis from date time " + currentDateTime + " is: " + currentDateTime.toEpochMilli());
    }

    @Test
    void testConvertLegacyToLatestDateAndTime(){
        Date legacyDateTime = new Date();

        Calendar calendar = Calendar.getInstance();
        Date legacyDateTime2 = calendar.getTime();

        Instant latestDateTime = legacyDateTime.toInstant(); // convert from Date to Instant
        // convert from Instant to other form of latest api
        ZonedDateTime fromInstantToZonedDateTime = latestDateTime.atZone(ZoneId.of("Asia/Jakarta"));
        LocalDateTime fromZonedDateTimeToLocalDateTime = fromInstantToZonedDateTime.toLocalDateTime();
        LocalDate fromZonedDateTimeToLocalDate = fromInstantToZonedDateTime.toLocalDate();
        LocalTime fromZonedDateTimeToLocalTime = fromInstantToZonedDateTime.toLocalTime();

        Instant latestDateTime2 = legacyDateTime2.toInstant(); // convert from Calendar to Instant
        // convert from Instant to other form of latest api
        OffsetDateTime fromInstantToOffsetDateTime = latestDateTime.atOffset(ZoneOffset.ofHours(7));
        LocalDateTime fromOffsetDateTimeToLocalDateTime = fromInstantToOffsetDateTime.toLocalDateTime();
        LocalDate fromOffsetDateTimeToLocalDate = fromInstantToOffsetDateTime.toLocalDate();
        LocalTime fromOffsetDateTimeToLocalTime = fromInstantToOffsetDateTime.toLocalTime();

        assertNotNull(latestDateTime);
        assertNotNull(latestDateTime2);

        assertNotNull(fromInstantToZonedDateTime);
        assertNotNull(fromZonedDateTimeToLocalDateTime);
        assertNotNull(fromZonedDateTimeToLocalDate);
        assertNotNull(fromZonedDateTimeToLocalTime);

        assertNotNull(fromInstantToOffsetDateTime);
        assertNotNull(fromOffsetDateTimeToLocalDateTime);
        assertNotNull(fromOffsetDateTimeToLocalDate);
        assertNotNull(fromOffsetDateTimeToLocalTime);

        System.out.println("Date to Instant: " + latestDateTime);
        System.out.println("Calendar to Instant: " + latestDateTime2);
        System.out.println("Instant to ZonedDateTime: " + fromInstantToZonedDateTime);
        System.out.println("Instant to OffsetDateTime: " + fromInstantToOffsetDateTime);
        System.out.println("ZonedDateTime to LocalDateTime: " + fromZonedDateTimeToLocalDateTime);
        System.out.println("OffsetDateTime to LocalDateTime: " + fromOffsetDateTimeToLocalDateTime);
        System.out.println("ZonedDateTime to LocalDate: " + fromZonedDateTimeToLocalDate);
        System.out.println("OffsetDateTime to LocalDate: " + fromOffsetDateTimeToLocalDate);
        System.out.println("ZonedDateTime to LocalTime: " + fromZonedDateTimeToLocalTime);
        System.out.println("OffsetDateTime to LocalTime: " + fromOffsetDateTimeToLocalTime);
    }

    @Test
    void testConvertLatestToLegacyDateAndTime(){
        ZonedDateTime currentZonedDateTime = ZonedDateTime.now();
        OffsetDateTime currentOffsetDateTime = OffsetDateTime.now();
        LocalDateTime currentLocalDateTime = LocalDateTime.now();

        // convert latest api to instant
        Instant instantFromZonedDateTime = currentZonedDateTime.toInstant();
        Instant instantFromOffsetDateTime = currentOffsetDateTime.toInstant();
        Instant instantFromLocalDateTime = currentLocalDateTime.toInstant(ZoneOffset.ofHours(7));

        // after convert latest api to instant then you can convert them to legacy api
        Date currentDate1 = Date.from(instantFromZonedDateTime);
        Date currentDate2 = Date.from(instantFromOffsetDateTime);
        Date currentDate3 = Date.from(instantFromLocalDateTime);

        assertNotNull(currentDate1);
        assertNotNull(currentDate2);
        assertNotNull(currentDate3);

        System.out.println("Current date 1: " + currentDate1);
        System.out.println("Current date 2: " + currentDate2);
        System.out.println("Current date 3: " + currentDate3);

    }
}
