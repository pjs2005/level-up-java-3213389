package com.linkedin.javacodechallenges;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class App {
    // Create function to calculate the date that's
    // 100 days from now

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 100);
        LocalDateTime localDate = LocalDateTime.now().plusDays(100);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E dd MMM yyyy");
        String dispayString = localDate.format(formatter);

        System.out.println("100 days from now is... " + cal.getTime());
        System.out.println("100 days from now is... " + dispayString);

    }
}
