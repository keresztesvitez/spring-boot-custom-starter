package com.adam;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "week-number-printer")
public class WeekNumberPrinterProperties {

    private String printFormat;

    public String getPrintFormat() {
        return printFormat;
    }

    public void setPrintFormat(String printFormat) {
        this.printFormat = printFormat;
    }
}
