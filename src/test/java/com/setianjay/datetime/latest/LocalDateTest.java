package com.setianjay.datetime.latest;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * {@link LocalDate} is a class that is used to create dates only.
 * <br />
 * <b>Format default: yyyy-MM-dd</b>
 * */
class LocalDateTest {
    private final String pattern = "dd-MM-yyyy";

    @Test
    void testCreateCurrentDate(){
        LocalDate localDate = LocalDate.now();

        String currentDate = DateTimeFormatter.ofPattern(pattern).format(localDate);

        assertNotNull(currentDate);

        System.out.println(currentDate);
    }

    @Test
    void testCreateSpecificDate(){
        // first way
        LocalDate specificDate = LocalDate.of(2000, Month.NOVEMBER, 11);
        String birthdayDate = specificDate.format(DateTimeFormatter.ofPattern(pattern));

        // second way
        LocalDate specificDate1 = LocalDate.of(2000, 11, 11);
        String birthdayDate1 = specificDate1.format(DateTimeFormatter.ofPattern(pattern));

        assertNotNull(birthdayDate);
        assertNotNull(birthdayDate1);

        System.out.println("My birthday is: " + birthdayDate);
        System.out.println("My birthday is: " + birthdayDate1);
    }

    @Test
    void testChangeDate(){
        LocalDate currentDate = LocalDate.now();
        LocalDate changeCurrentDateToMyBirthdayDate = currentDate.withYear(2000).withMonth(11).withDayOfMonth(11);

        assertNotNull(changeCurrentDateToMyBirthdayDate);

        System.out.println("Current date: " + currentDate);
        System.out.println("Change current date to my birthday date: " + changeCurrentDateToMyBirthdayDate);
    }

    @Test
    void testModifyDate(){
        LocalDate currentDate = LocalDate.now();

        LocalDate addFiveDaysFromCurrentDate = currentDate.plusDays(5);
        LocalDate minusFiveDaysFromCurrentDate = currentDate.minusDays(5);

        assertNotNull(addFiveDaysFromCurrentDate);
        assertNotNull(minusFiveDaysFromCurrentDate);

        System.out.println("Current date: " + currentDate);
        System.out.println("Add five days from current date: " + addFiveDaysFromCurrentDate);
        System.out.println("Minus five days from current date: " + minusFiveDaysFromCurrentDate);
    }

    @Test
    void testGetElements(){
        LocalDate currentDate = LocalDate.now();

        assertNotNull(currentDate);

        System.out.println("Year: " + currentDate.getYear());
        System.out.println("Month: " + currentDate.getMonth());
        System.out.println("Date: " + currentDate.getDayOfMonth());
        System.out.println("Day: " + currentDate.getDayOfWeek());
    }
}
