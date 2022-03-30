package org.sweatshop.tests;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeFormatterTest {

    public static void main(String[] args) {
        Date d = new Date();
        DateTimeFormatter iso8601Formatter = DateTimeFormatter.ISO_DATE_TIME;
        ZonedDateTime zdt = ZonedDateTime.ofInstant(d.toInstant(), ZoneId.of("Z"));
        System.out.println(zdt.format(iso8601Formatter));
    }
}
