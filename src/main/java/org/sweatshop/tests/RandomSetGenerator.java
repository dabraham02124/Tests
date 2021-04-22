package org.sweatshop.tests;

import java.util.Date;
import java.util.Random;

import io.vavr.collection.HashSet;
import io.vavr.collection.Set;

public class RandomSetGenerator {

    public static Set<Integer> createSet(long seed, int size, int range) {
        Random random = new Random(seed); 
        return HashSet.fill(size, (() -> Math.floorMod(random.nextInt(), range)));
    }

    public static void main(String[] args) {
        System.out.println(createSet(new Date().getTime(), 26, 29));
    }
}