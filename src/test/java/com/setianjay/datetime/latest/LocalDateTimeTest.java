package com.setianjay.datetime.latest;

import org.junit.jupiter.api.Test;

import java.time.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * {@link LocalDateTime} is a class that is used to create dates and times.
 * <br />
 * <b>Format default: yyyy-MM-ddTHH:mm:ss</b>
 * */
class LocalDateTimeTest {

    @Test
    void testCreateCurrentDateTime(){
        LocalDateTime currentDateTime = LocalDateTime.now();

        assertNotNull(currentDateTime);

        System.out.println("Current date time: " + currentDateTime);
    }

    @Test
    void testCreateSpecificDateTime(){
        // first way
        LocalDateTime localDateTime = LocalDateTime.of(2000, 11, 11, 14, 27, 55, 465000000);

        // second way
        LocalDateTime localDateTime1 = LocalDateTime.of(2000, 11, 11, 14, 27, 55);

        // third way
        LocalDateTime localDateTime2 = LocalDateTime.of(2000, Month.NOVEMBER, 11, 14, 27);

        assertNotNull(localDateTime);
        assertNotNull(localDateTime1);
        assertNotNull(localDateTime2);

        System.out.println("My born date time: " + localDateTime);
        System.out.println("My born date time(2): " + localDateTime1);
        System.out.println("My born date time(3): " + localDateTime2);
    }

    @Test
    void testCreateTimeWithTimeZone(){
        LocalDateTime timeAtWesternIndonesia = LocalDateTime.now();
        LocalDateTime timeAtMidIndonesia = LocalDateTime.now(ZoneId.of("Asia/Makassar"));
        LocalDateTime timeAtEasternIndonesia = LocalDateTime.now(ZoneId.of("Asia/Jayapura"));

        assertNotNull(timeAtWesternIndonesia);
        assertNotNull(timeAtMidIndonesia);
        assertNotNull(timeAtEasternIndonesia);

        System.out.println("WIB: " + timeAtWesternIndonesia);
        System.out.println("WITA: " + timeAtMidIndonesia);
        System.out.println("WIT: " + timeAtEasternIndonesia);
    }

    @Test
    void testChangeDateTime(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime changeToStartDateTimeInMyBirthday = currentDateTime
                .withYear(2000)
                .withMonth(11)
                .withDayOfMonth(11)
                .withHour(14)
                .withMinute(27)
                .withSecond(55)
                .withNano(465000000); // 1 second = 1 billion (miliar)

        assertNotNull(changeToStartDateTimeInMyBirthday);

        System.out.println("Current date time: " + currentDateTime);
        System.out.println("Change to start date time in my birthday: " + changeToStartDateTimeInMyBirthday);
    }

    @Test
    void testModifyDateTime(){
        LocalDateTime currentDateTime = LocalDateTime.now();

        LocalDateTime addFiveDaysAndFiveHoursFromCurrentDateTime = currentDateTime.plusDays(5).plusHours(5);
        LocalDateTime minusFiveDaysAndFiveHoursFromCurrentDateTime = currentDateTime.minusDays(5).minusHours(5);

        assertNotNull(addFiveDaysAndFiveHoursFromCurrentDateTime);
        assertNotNull(minusFiveDaysAndFiveHoursFromCurrentDateTime);

        System.out.println("Current date time: " + currentDateTime);
        System.out.println("Add five days and five hours from current date time: " + addFiveDaysAndFiveHoursFromCurrentDateTime);
        System.out.println("Minus five hours from current date time: " + minusFiveDaysAndFiveHoursFromCurrentDateTime);
    }

    @Test
    void testGetElements(){
        LocalDateTime currentDateTime = LocalDateTime.now();

        assertNotNull(currentDateTime);

        System.out.println("Year: " + currentDateTime.getYear());
        System.out.println("Month: " + currentDateTime.getMonth());
        System.out.println("Date: " + currentDateTime.getDayOfMonth());
        System.out.println("Day: " + currentDateTime.getDayOfWeek());
        System.out.println("Hour: " + currentDateTime.getHour());
        System.out.println("Minute: " + currentDateTime.getMinute());
        System.out.println("Second: " + currentDateTime.getSecond());
        System.out.println("Nano Second: " + currentDateTime.getNano());
    }

    @Test
    void testConvertLocalDateTimeToLocalDateAndReverse(){
        LocalDateTime currentDateTime = LocalDateTime.now();

        // convert LocalDateTime to LocalDate to get only Date
        LocalDate currentDate = currentDateTime.toLocalDate();
        assertNotNull(currentDate);
        System.out.println("Current date: " + currentDate);

        // convert LocalDate to LocalDateTime to get Date and Time
        LocalDateTime currentLocalDateTimeFromLocalDate = currentDate.atTime(LocalTime.now());
        assertNotNull(currentLocalDateTimeFromLocalDate);
        System.out.println("Current date time: " + currentLocalDateTimeFromLocalDate);
    }

    @Test
    void testConvertLocalDateTimeToLocalTimeAndReverse(){
        LocalDateTime currentDateTime = LocalDateTime.now();

        // convert LocalDateTime to LocalTime to get only Time
        LocalTime currentTime = currentDateTime.toLocalTime();
        assertNotNull(currentTime);
        System.out.println("Current time: " + currentTime);

        // convert LocalTime to LocalDateTime to get Date and Time
        LocalDateTime currentLocalDateTimeFromLocalTime = currentTime.atDate(LocalDate.now());
        assertNotNull(currentLocalDateTimeFromLocalTime);
        System.out.println("Current date time: " + currentLocalDateTimeFromLocalTime);
    }
}
