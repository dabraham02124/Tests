package org.sweatshop.tests;

import io.vavr.Tuple;
import io.vavr.collection.List;
import io.vavr.collection.Map;

public class FlatMapTester {

    public static void main(String[] args) {
        List<List<String>> list = List.of(List.of("a","b","c"), List.of("b", "c", "d"), List.of("a", "d", "e"));
        
        Map<String, List<String>> m = list.toMap(l -> Tuple.of(l.get(0), l));
        Map<String, List<List<String>>> foo = list.groupBy(l -> l.get(0));
        
        System.out.println(m);
        System.out.println(foo);
        
        Map<String, List<String>> foo2 = foo.map(e -> Tuple.of(e._1(), e._2().flatMap(subList -> subList))).toMap(e -> e);
        
        
        System.out.println(foo2);
    }
}
