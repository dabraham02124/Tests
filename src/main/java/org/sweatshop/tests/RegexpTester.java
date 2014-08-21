package org.sweatshop.tests;

import java.util.regex.Matcher;
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
        check("search?\\w+", (String)null);

    }

    private static void check(String regexp, String... testStrings) {
        Pattern p = Pattern.compile(regexp, Pattern.DOTALL);
        for (String testString : testStrings) {
            Matcher m = p.matcher(testString);
            if (m.matches()) {
                System.out.println("yes "+regexp+" matches "+testString);
            } else {
                System.out.println("no "+regexp+" does not match "+testString);
            }
        }
    }

}
