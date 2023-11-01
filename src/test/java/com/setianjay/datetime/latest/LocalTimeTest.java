package com.setianjay.datetime.latest;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * {@link LocalTime} is a class that is used to create times only.
 * <br />
 * <b>Format default: HH:mm:ss</b>
 * */
class LocalTimeTest {

    @Test
    void testCreateCurrentTime() {
        LocalTime currentTime = LocalTime.now();

        assertNotNull(currentTime);

        System.out.println("Current time: " + currentTime);
    }

    @Test
    void testCreateSpecificTime(){
        // first way
        LocalTime specificTime = LocalTime.of(10, 30, 45);

        // second way
        LocalTime specificTime1 = LocalTime.of(10, 30);

        assertNotNull(specificTime);
        assertNotNull(specificTime1);

        System.out.println("Specific time: " + specificTime);
        System.out.println("Specific time(2): " + specificTime1);
    }

    @Test
    void testCreateTimeWithTimeZone(){
        LocalTime timeAtWesternIndonesia = LocalTime.now();
        LocalTime timeAtMidIndonesia = LocalTime.now(ZoneId.of("Asia/Makassar"));
        LocalTime timeAtEasternIndonesia = LocalTime.now(ZoneId.of("Asia/Jayapura"));

        assertNotNull(timeAtWesternIndonesia);
        assertNotNull(timeAtMidIndonesia);
        assertNotNull(timeAtEasternIndonesia);

        System.out.println("WIB: " + timeAtWesternIndonesia);
        System.out.println("WITA: " + timeAtMidIndonesia);
        System.out.println("WIT: " + timeAtEasternIndonesia);
    }

    @Test
    void testChangeTime(){
        LocalTime currentTime = LocalTime.now();
        LocalTime changeToStartTimeInADay = currentTime.withHour(0).withMinute(0).withSecond(0).withNano(0);

        assertNotNull(changeToStartTimeInADay);

        System.out.println("Current time: " + currentTime);
        System.out.println("Change to start time in a day: " + changeToStartTimeInADay);
    }

    @Test
    void testModifyTime(){
        LocalTime currentTime = LocalTime.now();

        LocalTime addFiveHoursFromCurrentTime = currentTime.plusHours(5);
        LocalTime minusFiveHoursFromCurrentTime = currentTime.minusHours(5);

        assertNotNull(addFiveHoursFromCurrentTime);
        assertNotNull(minusFiveHoursFromCurrentTime);

        System.out.println("Current time: " + currentTime);
        System.out.println("Add five hours from current time: " + addFiveHoursFromCurrentTime);
        System.out.println("Minus five hours from current time: " + minusFiveHoursFromCurrentTime);
    }

    @Test
    void testGetElements(){
        LocalTime currentTime = LocalTime.now();

        assertNotNull(currentTime);

        System.out.println("Hour: " + currentTime.getHour());
        System.out.println("Minute: " + currentTime.getMinute());
        System.out.println("Second: " + currentTime.getSecond());
        System.out.println("Nano Second: " + currentTime.getNano());
    }
}
