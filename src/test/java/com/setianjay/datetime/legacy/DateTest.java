package com.setianjay.datetime.legacy;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * {@link Date} is a class that is used to create date and time.
 * */
class DateTest {

    @Test
    void testCreateCurrentDate(){
        Date currentDate = new Date();

        // assert the date object is not null
        assertNotNull(currentDate);

        System.out.println(currentDate);
    }

    @Test
    void testCreateSpecificDate(){
        Date dateOfMyBirthDay = new Date();
        dateOfMyBirthDay.setYear(2000);
        dateOfMyBirthDay.setMonth(10);
        dateOfMyBirthDay.setDate(11);

        /*-------- OR you can use this way for the concise code --------*/
        // Date dateOfMyBirthDay = new Date(973875600000L);

        // assert the date object is not null
        assertNotNull(dateOfMyBirthDay);

        System.out.println(dateOfMyBirthDay);
    }

    @Test
    void testGetSpecificElements(){
        Date currentDate = new Date();

        // assert the date object is not null
        assertNotNull(currentDate);

        System.out.println("Year: " + currentDate.getYear());
        System.out.println("Month: " + currentDate.getMonth());
        System.out.println("Date: " + currentDate.getDate());
        System.out.println("Day: " + currentDate.getDay());
        System.out.println("Hour: " + currentDate.getHours());
        System.out.println("Minute: " + currentDate.getMinutes());
        System.out.println("Second: " + currentDate.getSeconds());
        System.out.println("Timezone: " + currentDate.getTimezoneOffset());
    }
}
