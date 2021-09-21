package org.sweatshop.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiableList {

    public static void main(String[] args) {
        List<?> list = Collections.emptyList();
        System.out.println(list.toString());


        List<String> l2 = new ArrayList<>();
        l2.add("foo");
        List<String> l3 = Collections.unmodifiableList(l2);
        System.out.println("1 l2 = "+l2);
        System.out.println("1 l3 = "+l3);

        try {
            l3.add("bar");
            System.out.println("added bar to l3");
        } catch (Exception e) {
            System.out.println("threw exception " + e);
        }

        System.out.println("2 l2 = "+l2);
        System.out.println("2 l3 = "+l3);

        l2.add("bar");
        System.out.println("3 l2 = "+l2);
        System.out.println("3 l3 = "+l3);


    }

}
