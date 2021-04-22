package org.sweatshop.tests;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Dummy {


    private static String getSub2000SiebelString(String s) {
        int length = 1990;
        if (s.length() < length) {
            return s;
        } else {
            // logger.error("The Siebel text was longer than 2000 characters.  It was cut down, so this isn't fatal, but it shouldn't have happened.  The full text is:\n"+s);
            return s.substring(0, length);
        }
    }



    public static void main(String[] args) {
        String test = "1234567890";
        String test2 = multiplyString(test,199);

        test2 = test2.substring(0, 1985);
        testLength(test2);

        test2+="0";
        testLength(test2);

        test2+="0";
        testLength(test2);

        test2+="0";
        testLength(test2);

        test2+="0";
        testLength(test2);

        test2+="0";
        testLength(test2);

        test2+="0";
        testLength(test2);

        test2+="0";
        testLength(test2);

        test2+="0";
        testLength(test2);

        test2+="0";
        testLength(test2);

        test2+="0";
        testLength(test2);

        test2+="0";
        testLength(test2);

        String foo[] = {"a", "b"};
        List<String> bar = new LinkedList<String>(Arrays.asList(foo));
        System.out.println(bar);
    }


    private static void testLength(String sIn) {
        System.out.println("test2 is "+sIn.length());
        String output = getSub2000SiebelString(sIn);
        System.out.println("output is "+output.length());
    }


    private static String multiplyString(String sIn, int num) {
        String sOut = "";
        for (int i = 0; i < num; i++) {
            sOut += sIn;
        }
        return sOut;
    }

}
