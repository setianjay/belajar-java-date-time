package com.setianjay.datetime.latest;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * {@link Duration} is a class that represents time data. This class can be used to convert time to our desired
 * form such as hours, minutes, seconds and nanos. In addition, this class can also be used to calculate the difference
 * between times.
 * <br />
 * <br />
 * {@link Period} is a class that represent date data. This class can be used to convert date to our desired form such
 * as years, months, and days. In addition, this class can also be used to calculate the difference between date.
 * */
class DurationAndPeriodTest {

    @Test
    void testCountTime(){
        LocalTime startTime = LocalTime.of(7, 30);
        LocalTime arriveTime = LocalTime.of(8, 30);

        Duration lateDuration = Duration.between(startTime, arriveTime);

        assertNotNull(lateDuration);

        System.out.println("You are late for " + lateDuration);
    }

    @Test
    void testCountDate(){
        LocalDate bornDate = LocalDate.of(2000, 11, 11);
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(bornDate, currentDate);

        assertNotNull(period);

        System.out.println("You age is " + period.getYears());
    }
}
