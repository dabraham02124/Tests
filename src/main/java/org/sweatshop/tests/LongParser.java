package org.sweatshop.tests;

public class LongParser {

    public static void main(String[] args) {
        parseString("500");
        parseString("500l");

        System.out.println(new Long(86400 * 1000 * 365 * 2));
        System.out.println(new Long(86400l * 1000 * 365 * 2));
    }
    
    private static Long parseString(String sIn) {
        try {
        System.out.print(sIn+" = ");
        Long lOut = Long.parseLong(sIn);
        System.out.println(lOut);
        System.out.println();
        return lOut;
        } catch (Exception e) {
            System.out.println("doesn't parse");
            System.out.println();
            return 0l;
        }
    }

}
