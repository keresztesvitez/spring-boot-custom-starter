package com.adam.weeknumberprinterapp;

import com.adam.WeekNumberPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeekNumberPrinterAppApplication implements CommandLineRunner {

	@Autowired
	private WeekNumberPrinter weekNumberPrinter;

	public static void main(String[] args) {
		SpringApplication.run(WeekNumberPrinterAppApplication.class, args);
	}

	public void run(String... args) throws Exception {
		String message = weekNumberPrinter.getWeekNumber();
		System.out.println(message);
	}
}
