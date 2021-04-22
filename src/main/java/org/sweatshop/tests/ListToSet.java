package org.sweatshop.tests;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ListToSet {


    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        list.add(5);
        list.add(3);
        list.add(5);
        list.add(4);

        Set<Integer> set = Collections.unmodifiableSet(new HashSet<Integer>(list));

        System.out.println(set);
    }

}
