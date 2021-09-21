package org.sweatshop.tests;

import static java.lang.String.format;

import java.util.Date;

public class StringFormatVsConcat {
    private final static Integer count = 1000000;

    private final static String[] strings = getStrings();

    public static void main (String[] args) {
        formatVsPlus();
        formatVsStringBuffer();
    }

    private static String[] getStrings() {
        String[] strings = new String[count];

        for (int i = 0; i < count; i++) {
            strings[i] = Integer.toString(i);
        }
        return strings;
    }

    private static void formatVsPlus() {
        Date d1 = new Date();
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();

        for (int i = 0; i < count; i++) {
            sb1.append(format("foo %s", strings[i]));
        }

        Date d2 = new Date();

        for (int i = 0; i < count; i++) {
            sb2.append("foo " + strings[i]);
        }

        Date d3 = new Date();

//        System.out.println(sb1.toString());
//        System.out.println(sb2.toString());

        System.out.println("string format took "+(d2.getTime()-d1.getTime()));
        System.out.println("string plus took "+(d3.getTime()-d2.getTime()));
    }

    private static void formatVsStringBuffer() {
        StringBuffer sb = new StringBuffer();
        String output1 = new String();

        Date d1 = new Date();

        for (int i = 0; i < count; i++) {
            output1 = format("%s%s", output1, strings[i]);
        }

        Date d2 = new Date();

        for (int i = 0; i < count; i++) {
            sb.append(strings[i]);
        }

        Date d3 = new Date();

        System.out.println(output1);
        System.out.println(sb.toString());

        System.out.println("string format took "+(d2.getTime()-d1.getTime()));
        System.out.println("string buffer took "+(d3.getTime()-d2.getTime()));
    }
}
