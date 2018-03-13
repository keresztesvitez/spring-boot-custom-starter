package com.adam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.adam.WeekNumberPrinterConfigParams.PRINT_FORMAT;

@Configuration
@ConditionalOnClass(WeekNumberPrinter.class)
@EnableConfigurationProperties(WeekNumberPrinterProperties.class)
public class WeekNumberPrinterAutoConfiguration {

    @Autowired
    private WeekNumberPrinterProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public WeekNumberPrinterConfig weekNumberPrinterConfig() {
        String printFormat = properties.getPrintFormat() == null ? System.getProperty("printFormat") : properties.getPrintFormat();

        WeekNumberPrinterConfig config = new WeekNumberPrinterConfig();
        config.put(PRINT_FORMAT, printFormat);

        return config;
    }

    @Bean
    @ConditionalOnMissingBean
    public WeekNumberPrinter weekNumberPrinter(WeekNumberPrinterConfig weekNumberPrinterConfig) {
        return new WeekNumberPrinter(weekNumberPrinterConfig);
    }
}
