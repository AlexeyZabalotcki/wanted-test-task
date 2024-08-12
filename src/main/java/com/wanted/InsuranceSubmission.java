package com.report.generator.demo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class InsuranceSubmission {

    private static Set<LocalDate> holidays = new HashSet<>();

    static {
        holidays.add(LocalDate.of(2024, 1, 1));  // January 1st
        holidays.add(LocalDate.of(2024, 12, 25)); // December 25th
    }

    public static LocalDate getVacCheck(LocalDate modDate) {
        LocalDate date = modDate;

        while (isHolidayOrWeekend(date)) {
            date = date.plusDays(1);
        }

        return date;
    }

    private static boolean isHolidayOrWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            return true;
        }

        return holidays.contains(date);
    }

    public static void main(String[] args) {
        LocalDate today = LocalDate.of(2024, 8, 10);
        LocalDate nextWorkingDay = getVacCheck(today);
        System.out.println("Next working day: " + nextWorkingDay);
    }

}
