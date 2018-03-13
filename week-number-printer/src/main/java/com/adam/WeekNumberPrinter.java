package com.adam;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

import static com.adam.WeekNumberPrinterConfigParams.PRINT_FORMAT;

public class WeekNumberPrinter {

    private WeekNumberPrinterConfig config;

    public WeekNumberPrinter(WeekNumberPrinterConfig config) {
        this.config = config;
    }

    public String getWeekNumber(LocalDate localDate) {

        String format = config.getProperty(PRINT_FORMAT);

        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int weekNumber = localDate.get(weekFields.weekOfYear());

        return String.format(format, weekNumber);

    }

    public String getWeekNumber() {
        return getWeekNumber(LocalDate.now());
    }
}
