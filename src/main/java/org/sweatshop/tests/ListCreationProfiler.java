package org.sweatshop.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ListCreationProfiler {
    
    public static void main(String[] args) {
        runNumbers(3, 100);
        runNumbers(3, 1000);
        runNumbers(3, 10000);
        runNumbers(3, 100000);
        runNumbers(3, 1000000);
        runNumbers(30, 100);
        runNumbers(30, 1000);
        runNumbers(30, 10000);
        runNumbers(30, 100000);
        runNumbers(300, 100);
        runNumbers(300, 1000);
        runNumbers(300, 10000);
//        runNumbers(300, 100000);  causes OutOfMemoryError
    }
    
    private static void runNumbers(int numberOfLists, int elementsInList) {
        List<List<String>> stringListList1 = new ArrayList<>();
        fillInListList(stringListList1, numberOfLists);
        
        Date d1 = new Date();
        for (int i = 0; i < elementsInList; i++) {
            for (List<String> list : stringListList1) {
                list.add(String.valueOf(i));
            }
        }
        
        Date d2 = new Date();

        stringListList1 = new ArrayList<>();
        fillInListList(stringListList1, numberOfLists);
        
        Date d3 = new Date();
        
        for (List<String> list : stringListList1) {
            for (int i = 0; i < elementsInList; i++) {
                list.add(String.valueOf(i));
            }
        }
        
        
        Date d4 = new Date();
        
        
        System.out.println(String.format("lists = %s, elements = %s, loop 1 = %s, loop 2 = %s",
                numberOfLists, elementsInList,(d2.getTime() - d1.getTime()), (d4.getTime() - d3.getTime())));
    }

    private static void fillInListList(List<List<String>> stringListList, int numberoflists2) {
        for (int i = 0; i < numberoflists2; i++) {
            stringListList.add(new ArrayList<String>());
        }
    }

}
