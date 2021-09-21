package org.sweatshop.tests;

import java.time.Instant;
import java.util.Date;

public class DateStuff {
    public static void main(String[] args) {
        System.out.println(new Date());

        Instant instant = Instant.parse("2019-05-01T23:49:34.458Z");
        long epoch = instant.toEpochMilli() / 1000;
        System.out.format("instant = %s, epoch = %d", instant, epoch);
    }
}
