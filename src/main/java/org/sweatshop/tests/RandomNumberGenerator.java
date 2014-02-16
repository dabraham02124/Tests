package org.sweatshop.tests;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RandomNumberGenerator {

    private final static int totalNumbers = 10;
    private final static int maxNumber = 286;
    private final static List<Integer> list = new LinkedList<>();
    
    public static void main(String[] args) {
        for (int i = 0; i < totalNumbers ; i++) {
            list.add((int)(Math.random() * maxNumber));
        }
        Collections.sort(list);
        for (int i = 0; i < totalNumbers ; i++) {
            System.out.println(String.format("sorted pseudo random number %s is %s", i+1, list.get(i)));
        }

    }
}
