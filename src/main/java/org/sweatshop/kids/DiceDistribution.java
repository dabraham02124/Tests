package org.sweatshop.kids;

import io.vavr.collection.HashMap;
import io.vavr.collection.Map;

public class DiceDistribution {
    public static int roll(int dice, int sides) {
        int total = 0;
        for (int i = 0; i < dice; i++) {
            total += (Math.random() * sides) +1;
        }
        return total;
    }
    
    
    public static void main(String[] args) {
        Map<Integer, Integer> distribution = HashMap.empty();
        
        int runs = 10_000_000;
        int dice = 4;
        int sides = 6;
        for (int i = dice; i <= dice * sides; i++) {
            distribution = distribution.put(i, 0);
        }
        
        for (int i = 0; i < runs; i++) {
            int total = roll(dice, sides);
            distribution = distribution.put(total, distribution.get(total).get() + 1);
        }
        
        for (int i = dice; i <= dice * sides; i++) {
            System.out.format("%s dice, %s sides, total %s, times %s\n", dice, sides, i, distribution.get(i).get());
        }

    }
    

}
