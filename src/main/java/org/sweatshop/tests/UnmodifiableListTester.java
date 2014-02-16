package org.sweatshop.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class UnmodifiableListTester {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        
        Date date1 = new Date();
        
        for (Integer i : list) {
            if (i == -10000) {
                System.out.print(i);
            }
        }
        
        Date date2 = new Date();
        
        int indirectionLevels = 2000;
        for (int i = 0; i < indirectionLevels; i++) {
            list = Collections.unmodifiableList(list);
        }
        
        Date date3 = new Date();
        
        for (Integer i : list) {
            if (i == -10000) {
                System.out.print(i);
            }
        }

        Date date4 = new Date();
        
        System.out.println("list created "+ date1.getTime());
        System.out.println("list dumped "+date2.getTime());
        System.out.println(indirectionLevels+" levels of indirection created "+date3.getTime());
        System.out.println("indirect list dumped "+ date4.getTime());
        System.out.println("\n\n\n");
        
        System.out.println("time to dump straight = "+(date2.getTime() - date1.getTime()));
        System.out.println("time to dump very indirect = "+(date4.getTime() - date3.getTime()));

    }
}
