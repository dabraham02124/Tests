package org.sweatshop.tests;

import static java.lang.String.format;

public class IntegerTester {

    public static void main(String[] args) {
        Integer i = Integer.parseInt("14");
        System.out.println(i.toString());

        int a = 5;
        int b = 6;
        System.out.println(format("%s, %s %s", a, b, ((Integer)a).compareTo(b)));
        System.out.println(format("%s, %s %s", b,a, ((Integer)b).compareTo(a)));
        System.out.println(format("%s, %s %s", a, a, ((Integer)a).compareTo(a)));

        System.out.println(null instanceof Integer);
    }
}