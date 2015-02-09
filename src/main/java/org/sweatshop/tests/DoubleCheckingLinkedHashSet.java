package org.sweatshop.tests;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DoubleCheckingLinkedHashSet {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(1);
        list.add(5);
        list.add(9);
        list.add(2);
        list.add(6);
        
        
        Set<Integer> set = new LinkedHashSet<>(list);
        
        set.add(8);
        set.add(7);
        
        for (int i : set) {
            System.out.println(i);
        }
    }
    
}
