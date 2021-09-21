package org.sweatshop.tests;

public class EqualityTester {

    private String foo;

    public void blah(EqualityTester eq) {
        eq.foo = "bla";
        System.out.println(eq.foo);
    }

    private static void setAndTestEquality (int i) {
        Integer integer1;
        Integer integer2;

        integer1 = new Integer(i);
        integer2 = new Integer(i);
        System.out.println(integer1 == integer2);

        integer1 = i;
        integer2 = i;
        System.out.println(integer1 == integer2);
    }

    public static void main (String[] args) {
        setAndTestEquality(17);
        setAndTestEquality(700);
        EqualityTester eq1 = new EqualityTester();
        eq1.blah(new EqualityTester());
    }

}
