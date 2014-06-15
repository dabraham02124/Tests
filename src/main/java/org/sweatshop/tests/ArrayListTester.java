package org.sweatshop.tests;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTester {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(20);

        printList(list);
        
        list.add("foo");
        list.add("foo");
        list.add("foo");
        list.add("foo");
        list.add("foo");
        
        printList(list);
    }

    private static void printList(List<String> list) {
        System.out.println(String.format("The list is of size %s and is %s", list.size(), list));
    }

}
