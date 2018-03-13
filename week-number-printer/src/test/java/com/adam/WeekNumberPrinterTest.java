package com.adam;

import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

import static com.adam.WeekNumberPrinterConfigParams.PRINT_FORMAT;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WeekNumberPrinterTest {

    private static WeekNumberPrinterConfig config;

    @BeforeClass
    public static void initConfig() {
        config = new WeekNumberPrinterConfig();
        config.put(PRINT_FORMAT, "Week of the Year: %s");
    }

    @Test
    public void testShouldPrintWeekOfYear() {
        String expected = "Week of the Year: 1";
        WeekNumberPrinter weekNumberPrinter = new WeekNumberPrinter(config);
        String actual = weekNumberPrinter.getWeekNumber(LocalDate.of(2018, 1, 1));
        assertThat(actual, is(expected));
    }
}