package org.sweatshop.tests;

public class SubstringTester {


    public static void main(String[] args) {
        String test = "abcd";
        System.out.println(safeTruncateString(test, 2));
        System.out.println(safeTruncateString(test, 3));
        System.out.println(safeTruncateString(test, 4));
        System.out.println(safeTruncateString(test, 5));
        System.out.println(safeTruncateString(test, 6));
    }

    private static String safeTruncateString(String string, int length) {
        if (string.length() <= length) {
            return string;
        } else {
            return string.substring(0, length);
        }
    }
}
