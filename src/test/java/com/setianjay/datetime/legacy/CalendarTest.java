package com.setianjay.datetime.legacy;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * {@link Calendar} is a class that is used to create date and time. This class is also the recommended class to use in
 * legacy api instead of using Date class.
 * */
class CalendarTest {

    @Test
    void testCreateCurrentDate(){
        Calendar calendar = Calendar.getInstance(); // getInstance() method return current date time

        // get Date object from Calendar
        Date currentDate = calendar.getTime();

        // assert the Calendar object and Date object is not null
        assertNotNull(calendar);
        assertNotNull(currentDate);

        System.out.println(currentDate);
    }

    @Test
    void testCreateSpecificDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2000); // set year
        calendar.set(Calendar.MONTH, Calendar.NOVEMBER); // set month
        calendar.set(Calendar.DAY_OF_MONTH, 11); // set day
        calendar.set(Calendar.HOUR_OF_DAY, 22); // set hour
        calendar.set(Calendar.MINUTE, 45); // set minute
        calendar.set(Calendar.SECOND, 35); // set second

        /*-------- OR you can use this way for the concise code --------*/
        // calendar.setTime(new Date(973957535000L)); // using millis

        // get Date object from Calendar
        Date dateOfMyBirthDay =  calendar.getTime();

        // assert the Date object is not null
        assertNotNull(dateOfMyBirthDay);

        System.out.println(dateOfMyBirthDay);
    }

    @Test
    void testGetSpecificElements(){
        Calendar calendar = Calendar.getInstance();

        assertNotNull(calendar);

        System.out.println("Year: " + calendar.get(Calendar.YEAR));
        System.out.println("Month: " + calendar.get(Calendar.MONTH));
        System.out.println("Date: " + calendar.get(Calendar.DATE));
        System.out.println("Day: " + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("Hour: " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("Minute: " + calendar.get(Calendar.MINUTE));
        System.out.println("Second: " + calendar.get(Calendar.SECOND));
    }
}
