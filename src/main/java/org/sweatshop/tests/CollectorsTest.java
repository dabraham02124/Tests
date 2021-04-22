package org.sweatshop.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.Value;


public class CollectorsTest {
    
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("foo1", "bar1");
        map.put("foo2", "bar2");
        map.put("foo3", "bar3");
        
        Map<String, String> map2 = map.entrySet().stream()
                .map(e -> new Pair<String, String>(e.getKey() + "-", e.getValue()))
                .collect(Collectors.toMap(p -> p.getK(), p -> p.getV()));
        
        System.out.println(map2);
        emptyListCollect();
    }
    
    @Value
    public static class Pair<K,V> {
        K k;
        V v;
    }
    
    public static <K, V> V addToMap(Map<K, V> map, Pair<K, V> pair) {
        return map.put(pair.getK(), pair.getV());
    }
    
    public static void emptyListCollect() {
        System.out.println(new ArrayList<>().stream().collect(Collectors.toList()));
        List<String> list = new ArrayList<>(); //turns out Arrays.asList has a null check for some insane reason...
        list.add(null);
        System.out.println(list.stream().collect(Collectors.toList()));

    }

}
