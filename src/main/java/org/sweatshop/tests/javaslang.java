package org.sweatshop.tests;

import javaslang.collection.List;

import static java.lang.String.format;

import java.util.Date;
import java.util.LinkedList;

import javaslang.Function0;
import javaslang.Tuple;
import javaslang.Tuple2;
import javaslang.collection.HashMap;
import javaslang.collection.Map;
import javaslang.control.Try;

public class javaslang {
    
    public static void main(String[] args) {
        
        tryOf();
        
        List<String> list = List.of("foo", "bar");
        
        for (String s : list) {
            System.out.println(s);
        }
        
        String[] ss = {"a","b","c"};
        List<String> sList = fromArray(ss);
        System.out.println(sList);
        List<String> sList2 = sList.append("d");
        System.out.println(sList);
        System.out.println(sList2);
        
        System.out.println();
        System.out.println();
        
        
        time("array list 0", () -> runArrayList(0));
        time("array list max", () -> runArrayList(max));
        time("linked list", () -> runLinkedList());
        time("linked list to jsl", () -> runLinkedListToJsl());
        time("jsl", () -> runJsl());
//        time("jsl", () -> runJsl());
        
        
        System.out.println();
        System.out.println();
        
        Map<String, String> map = HashMap.empty();
        Tuple2<String, String> t1 = Tuple.of("a", "b");
        Map<String, String> map1 = map.put(t1);
        Tuple2<String, String> t2 = Tuple.of("c", "d");
        Map<String, String> map2 = map1.put(t2);
        Tuple2<String, String> t3 = Tuple.of("e", "f");
        Map<String, String> map3 = map2.put(t3);
        
        System.out.println(map3.get());
        System.out.println(map3.get());
        System.out.println(map2.get("e"));
        System.out.println(map3.get("e").get());
    }
    
    private static void tryOf() {
        int i = 10;
        Integer j = Try.of(() -> 
                    maybeThrow(
                            maybeThrow(
                                    maybeThrow(i)
                            )))
                .onFailure(e -> e.printStackTrace())
                .getOrElse(new Integer(0));
        System.out.println(j);
    }

    private static Integer maybeThrow(int i) {
        if (i >= 10) {
            throw new RuntimeException();
        } else {
            return i+1;
        }
    }

    private static void time(String name, Function0<Integer> f) {
        Date d1 = new Date();
        f.apply();
        Date d2 = new Date();
        
        System.out.println(format("%s took %s time", name, d2.getTime() - d1.getTime()));
    }

    private static final int max = 10_000;
    private static int runArrayList(int initSize) {
        java.util.List<Integer> list = new java.util.ArrayList<>(initSize); 
        for (int i = 0; i < max; i++) {
            list.add(i);
        }
        return list.get(14);
    }

    private static int runLinkedList() {
        java.util.List<Integer> list = new LinkedList<>(); 
        for (int i = 0; i < max; i++) {
            list.add(i);
        }
        return list.get(14);
    }

    private static int runLinkedListToJsl() {
        java.util.List<Integer> list = new LinkedList<>(); 
        for (int i = 0; i < max; i++) {
            list.add(i);
        }
        List<Integer> list2 = List.ofAll(list);
        return list2.get(14);    }

    private static int runJsl() {
        List<Integer> list = List.empty(); 
        for (int i = 0; i < max; i++) {
            list = list.append(i);
        }
        return list.get(14);
    }
    
    public static <T> List<T> fromArray(T[] ts) {
        List<T> list = List.empty();
        for (T t : ts) {
            list = list.append(t);
        }
        return list;
    }

}
