package org.sweatshop.tests;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SDFTester {
    private static SimpleDateFormat gitDateSDF = new SimpleDateFormat("EEE, MMM d HH:mm:ss yyyy Z");

    public static void main(String[] args) {
        System.out.println(gitDateSDF.format(new Date()));
    }
}
