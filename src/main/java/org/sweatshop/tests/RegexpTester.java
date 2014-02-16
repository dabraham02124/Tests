package org.sweatshop.tests;

import java.util.regex.Pattern;

public class RegexpTester {

    /**
     * @param args
     */
    public static void main(String[] args) {
        check("search", "search");
        check("search", "searchh");
        check("search?", "search");
        check("search?", "searchh");
        check("search?\\w+", "searchhhh");

    }

    private static void check(String regexp, String testString) {
        if (Pattern.matches(regexp, testString)) {
            System.out.println(regexp+" matches "+testString);
        } else {
            System.out.println(regexp+" does not match "+testString);
        }
    }

}
