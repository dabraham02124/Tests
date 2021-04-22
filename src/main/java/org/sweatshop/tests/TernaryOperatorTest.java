package org.sweatshop.tests;

public class TernaryOperatorTest {

    public static void main(String[] args) {

        //case 1
        System.out.println(returnTrue() ? new Integer(1) : new Double(2.4));

        //case 2
        Object o1 = returnTrue() ? null : new Double(2.4);
        System.out.println(o1);

        //case 3
        Integer i = new Integer(1);
        if (returnTrue()) {
            i = null;
        }
        Object o2 = returnTrue() ? i : new Double(2.4);
        System.out.println(o2);

    }

    public static boolean returnTrue() {
        return true;
    }
}
