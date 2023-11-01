package com.setianjay.datetime.legacy;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * {@link TimeZone} is a class that is used to create a time zone for legacy api.
 * */
class TimeZoneTest {


    @Test
    void testGetAllTimeZoneId(){
        String[] timeZoneIds = TimeZone.getAvailableIDs();

        assertNotEquals(0, timeZoneIds.length);

        for(String timeZoneId: timeZoneIds){
            System.out.println(timeZoneId);
        }
    }

    /**
     * By default, {@link Date} object can't handle modification for Time Zone. Date object will always use the default
     * Time Zone in an operating system that we use. <br />
     * -----------------------------------------------------------------------------------------------------------------
     * <br />
     * Note: If we want to change the time zone, we can use the {@link Calendar} object.
     * */
    @Test
    void testTimeZoneUsingDateObject(){
        Date currentDate = new Date();

        // assert Date object is not null
        assertNotNull(currentDate);

        System.out.println("Current Date in Western Indonesia: " + currentDate);
        System.out.println("Current Date in Britannia Raya: " + currentDate.toGMTString());
    }

    @Test
    void testTimeZoneUsingCalendarObject(){
        Calendar calendarWIB = Calendar.getInstance(); // default time zone in my operating system (Asia/Jakarta) or WIB
        Calendar calendarWITA = Calendar.getInstance(TimeZone.getTimeZone("Asia/Makassar")); // time zone for WITA
        Calendar calendarWIT = Calendar.getInstance(TimeZone.getTimeZone("Asia/Jayapura")); // time zone for WIT

        assertNotNull(calendarWIB);
        assertNotNull(calendarWITA);
        assertNotNull(calendarWIT);

        /*
        * If we use Calendar to set the TimeZone and call the getTime() method, the program will return the time in the
        * operating system even if we have changed the time zone.
        *
        * But if we access it piece-wise like its hour, minute, or second. it will return the time according to the time
        * zone.
        * */
//        System.out.println("WIB time: " + calendarWIB.getTime()); // return time in WIB
//        System.out.println("WITA time: " + calendarWITA.getTime()); // return time in WIB not WITA
//        System.out.println("WIT time: " + calendarWIT.getTime()); // return time in WIB not WIT

        System.out.println("WIB time: " + calendarWIB.get(Calendar.HOUR_OF_DAY)); // return hour in WIB
        System.out.println("WITA time: " + calendarWITA.get(Calendar.HOUR_OF_DAY)); // return hour in WIB
        System.out.println("WIT time: " + calendarWIT.get(Calendar.HOUR_OF_DAY)); // return hour in WIT
    }

    @Test
    void testTimeZoneUsingSimpleDateFormatObject(){
        Date currentDate = new Date();

        String pattern = "dd-MM-yyyy HH:mm:ss";

        // WIB
        SimpleDateFormat wibSimpleDateFormat = new SimpleDateFormat(pattern);
        wibSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Jakarta"));

        // WITA
        SimpleDateFormat witaSimpleDateFormat = new SimpleDateFormat(pattern);
        witaSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Makassar"));

        // WIT
        SimpleDateFormat witSimpleDateFormat = new SimpleDateFormat(pattern);
        witSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Jayapura"));

        assertNotNull(wibSimpleDateFormat);
        assertNotNull(witaSimpleDateFormat);
        assertNotNull(witSimpleDateFormat);

        // Change current date to the pattern we use, to represent date and time on each time zone
        String jakartaZonedDateTimeFormat = wibSimpleDateFormat.format(currentDate);
        String makassarZonedDateTimeFormat = witaSimpleDateFormat.format(currentDate);
        String papuaZonedDateTimeFormat = witSimpleDateFormat.format(currentDate);

        System.out.println("Time in Jakarta (WIB): " + jakartaZonedDateTimeFormat);
        System.out.println("Time in Makassar (WITA): " + makassarZonedDateTimeFormat);
        System.out.println("Time in Jayapura (WIT): " + papuaZonedDateTimeFormat);
    }
}
