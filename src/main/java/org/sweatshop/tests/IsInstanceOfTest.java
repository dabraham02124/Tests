package org.sweatshop.tests;

public class IsInstanceOfTest {

    public static void main(final String[] args) {

        String s = "";

        System.out.println((s instanceof String));
        System.out.println(String.class.isInstance(s));

        s = null;

        System.out.println((s instanceof String));
        System.out.println(String.class.isInstance(s));
    }
}