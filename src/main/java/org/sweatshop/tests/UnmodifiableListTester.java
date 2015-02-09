package org.sweatshop.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class UnmodifiableListTester {

    public static void main(String[] args) {
        t1();
    }
    
    
    public static void t2() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> list2 = Collections.unmodifiableList(list);
        System.out.println(list2.size());
        list.add(6);
        System.out.println(list2.size());
    }

    private static void iterateThroughList(final List<Integer> list, final int guaranteedNotThere) {
        for (Integer i : list) {
            if (i == guaranteedNotThere) {
                System.out.print(i);
            }
        }
    }
    
    private static List<Integer> createListFrom1ToN(final int n) {
        List<Integer> list = new ArrayList<>(n);
        
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        
        return list;
    }

    public static void t1() {
        final int listSize = 100000;
        final int guaranteedNotThere = -1;
        int indirectionLevels = 0;
        
        List<Integer> list = createListFrom1ToN(listSize);
        
        Date date1 = new Date();
        iterateThroughList(list, guaranteedNotThere);
        Date date2 = new Date();
        
        for (int i = 0; i < indirectionLevels; i++) {
            list = Collections.unmodifiableList(list);
        }
        
        Date date3 = new Date();
        iterateThroughList(list, guaranteedNotThere);
        Date date4 = new Date();
        
        System.out.println("list created "+ date1.getTime());
        System.out.println("list dumped "+date2.getTime());
        System.out.println(indirectionLevels+" levels of indirection created "+date3.getTime());
        System.out.println("indirect list dumped "+ date4.getTime());
        System.out.println("\n\n\n");
        
        long d2_1 = date2.getTime() - date1.getTime();
        long d4_3 = date4.getTime() - date3.getTime();
        System.out.println(String.format("time to dump straight = %s, that's %s/second.",d2_1, listSize/d2_1));
        System.out.println(String.format("time to dump %s indirect = %s, that's %s/second, or %s/indirection level/second.", 
                indirectionLevels, d4_3, listSize/d4_3, listSize/(((float)d4_3)/indirectionLevels)));
    }
}
