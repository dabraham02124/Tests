package org.sweatshop.tests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Iterators {

    public static void main(String[] args) {
        int size = 10_000_000;
        List<String> list = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            list.add(String.valueOf(i));
        }

        Date d1;
        Date d2;
        long total;
        
        total = 0;
        d1 = new Date();
        total = list.parallelStream().map(x -> Long.parseLong(x)).reduce(0l, ((x,y) -> x+y));
        d2 = new Date();
        System.out.println(java.lang.String.format("p-stream -- total = %s, time = %s", total, d2.getTime() - d1.getTime()));

        
        total = 0;
        d1 = new Date();
        total = list.stream().map(x -> Long.parseLong(x)).reduce(0l, ((x,y) -> x+y));
        d2 = new Date();
        System.out.println(java.lang.String.format("stream   -- total = %s, time = %s", total, d2.getTime() - d1.getTime()));

        
        total = 0;
        d1 = new Date();
        for (int i = 0; i < size; i++) {
            total += Integer.parseInt(list.get(i));
        }
        d2 = new Date();
        System.out.println(java.lang.String.format("for loop -- total = %s, time = %s", total, d2.getTime() - d1.getTime()));


        total = 0;
        d1 = new Date();
        for (String s : list) {
            total += Integer.parseInt(s);
        }
        d2 = new Date();
        System.out.println(java.lang.String.format("iterator -- total = %s, time = %s", total, d2.getTime() - d1.getTime()));

    }

}
