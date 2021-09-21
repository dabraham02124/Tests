package org.sweatshop.tests;

import java.text.DecimalFormat;

public class DecimalFormatTester {

    public static void main(String[] args) {
        DecimalFormat df = null;

        df = new DecimalFormat("#######");
        for (int i = 1; i < 1000000; i *= 10) {
            System.out.println(df.format(i));
        }

        df = new DecimalFormat("0000000");
        for (int i = 1; i < 1000000; i *= 10) {
            System.out.println(df.format(i));
        }
    }

}
