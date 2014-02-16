package org.sweatshop.tests;

import java.util.regex.Pattern;

public class PatternTester {

    
    private static void showMatching(String pattern, String string) {
        printMatching(match1(pattern, string), pattern, string);
        printMatching(match2(pattern, string), pattern, string);
    }

        
    private static void printMatching(boolean matches, String pattern, String string) {
        System.out.print(matches ? "yes, pattern " : "no, pattern ");
        System.out.print(pattern);
        System.out.print(matches ? " matches string " : " does NOT match string ");
        System.out.println(string);
        
    }
    
    private static boolean match1(String pattern, String string) {
        return Pattern.matches(pattern, string);
    }
    
    private static boolean match2(String patternText, String string) {
        Pattern pattern = Pattern.compile(patternText);
        return pattern.matcher(string).matches();
    }
    
    
    public static void main(String[] args) {
        
        showMatching("cps", "cps");
        showMatching("/cps/v\\d\\.\\d/context/\\w*", "/cps/v0.1/context/");
        showMatching("/cps/v\\d\\.\\d/context/\\w*", "/cps/v0.1/context/fafhFFD35dF");
        showMatching("/cps/v\\d\\.\\d/context/\\w+/subscription/\\w*", "/cps/v0.1/context/fafhFFD35dF/subscription/");
        showMatching("/cps/v\\d\\.\\d/context/\\w+/subscription/\\w*", "/cps/v0.1/context/fafhFFD35dF/subscription/gsdfRRRA453H");
        showMatching("/cps/v\\d\\.\\d/context/\\w*", "/cps/v0.1/context/123");
    }

}
