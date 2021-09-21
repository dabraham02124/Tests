package org.sweatshop.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Days15000 {


    public static void main(String[] args) throws ParseException {
        Calendar c = new GregorianCalendar(1973, 01, 03);
        c.add(Calendar.DATE, 15_000);
        System.out.println(new SimpleDateFormat("yyyyMMdd").format(c.getTime()));
    }
}
