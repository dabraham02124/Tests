package org.sweatshop.tests;

public class SubstringTester {

    
    public static void main(String[] args) {
        String test = "abcd";
        System.out.println(safeTruncateString(test, 2));
        System.out.println(safeTruncateString(test, 3));
        System.out.println(safeTruncateString(test, 4));
        System.out.println(safeTruncateString(test, 5));
        System.out.println(safeTruncateString(test, 6));
        
        
        System.out.println(replaceSubstring("Dorian hates anime", "hate", "love"));
        System.out.println(replaceSubstring("Dorian likes anime", "hate", "love"));
        System.out.println(replaceSubstring(null, "hate", "love"));
        System.out.println(replaceSubstring("Dorian hates anime", null, "love"));
        System.out.println(replaceSubstring("Dorian hates anime", "hate", null));

    }
    
    private static String safeTruncateString(String string, int length) {
        if (string.length() <= length) {
            return string;
        } else {
            return string.substring(0, length);
        }
    }
    
    private static String replaceSubstring(String in, String replaced, String replacement) {
        if (null == in || null == replaced) {
            return in;
        } else {
            int index = in.indexOf(replaced);
            if (-1 == index) {
                return in;
            } else {
                return in.substring(0, index) + replacement + in.substring(index + replaced.length());
            }
        }
    }
    
}
