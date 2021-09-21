package org.sweatshop.tests;

public class ExceptionTester {

    public static void main(String[] args) {
        try {
            throw new RuntimeException("THis is a test");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
