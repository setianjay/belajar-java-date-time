package com.setianjay.datetime.latest;

import org.junit.jupiter.api.Test;

import java.time.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * {@link Year} is a class that is used to create years only.
 * <br />
 * {@link YearMonth} is a class that is used to create years and month only.
 * <br />
 * {@link MonthDay} is a class that is used to create months and days only.
 * */
class YearMonthDayTest {

    @Test
    void createOnlyYear(){
        Year currentYear = Year.now();
        Year specificYear = Year.of(2000);

        assertNotNull(currentYear);
        assertNotNull(specificYear);

        System.out.println(currentYear);
        System.out.println(specificYear);
    }

    @Test
    void createOnlyYearAndMonth(){
        YearMonth currentYearAndMonth = YearMonth.now();
        YearMonth specificYearAndMonth = YearMonth.of(2000, 11);

        assertNotNull(currentYearAndMonth);
        assertNotNull(specificYearAndMonth);

        System.out.println(currentYearAndMonth);
        System.out.println(specificYearAndMonth);
    }

    @Test
    void createOnlyMonthAndDay(){
        MonthDay currentMonthAndDay = MonthDay.now();
        MonthDay specificMonthAndDay = MonthDay.of(11, 11);

        assertNotNull(currentMonthAndDay);
        assertNotNull(specificMonthAndDay);

        System.out.println(currentMonthAndDay);
        System.out.println(specificMonthAndDay);
    }

    @Test
    void convertYearToYearMonth(){
        Year currentYear = Year.now();

        // convert current Year to current YearMonth
        YearMonth currentYearAndMonth = currentYear.atMonth(11);

        assertNotNull(currentYearAndMonth);

        System.out.println("Current year: " + currentYear);
        System.out.println("Current year convert to current year and month: " + currentYearAndMonth);
    }

    @Test
    void convertYearToLocalDate(){
        Year currentYear = Year.now();

        // convert current Year to current YearMonth
        YearMonth currentYearAndMonth = currentYear.atMonth(11);
        // convert current YearMonth to LocalDate
        LocalDate currentDate = currentYearAndMonth.atDay(11);

        assertNotNull(currentYearAndMonth);
        assertNotNull(currentDate);

        System.out.println("Current year: " + currentYear);
        System.out.println("Current year convert to current year and month: " + currentYearAndMonth);
        System.out.println("Current year and month convert to local date: " + currentDate);
    }
}
