package org.sweatshop.tests;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss.SSS");
        Date now = new Date();
        long ctm = System.currentTimeMillis();
        System.out.println(sdf.format(now));
        System.out.println(sdf.format(now.getTime() + (1000L * 60 * 300)));
        System.out.println(ctm);
    }
}
