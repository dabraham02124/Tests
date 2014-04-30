package org.sweatshop.tests;

public class LongParser {

    public static void main(String[] args) {
        parseString("500");
        parseString("500L");

    }
    
    private static Long parseString(String sIn) {
        System.out.print(sIn+" = ");
        Long lOut = Long.parseLong(sIn);
        System.out.println(lOut);
        System.out.println();
        return lOut;
    }

}
