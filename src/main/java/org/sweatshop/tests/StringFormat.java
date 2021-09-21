package org.sweatshop.tests;

import static java.lang.String.format;

public class StringFormat {

    public static void main(String[] args) {
        int foo = 15;
        System.out.println(format("this is an int as string %s",foo));
        System.out.println(format("this is an int as int    %d",foo));
        System.out.println(format("this is a null %s", returnNull()));
        System.out.println(format("This is too many variables %s",1,2,3,4));
    }

    private static Object returnNull() {
        return null;
    }

}
