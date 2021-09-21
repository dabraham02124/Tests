package org.sweatshop.tests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashMap<K, V> implements Map<K, V> {

    private class Pair<K2, V2> {
        private final K2 k; public K2 getK() { return k;}
        private final V2 v;public V2 getV() { return v;}
        
        public Pair(K2 k, V2 v) {
            this.k = k;
            this.v = v;
        }
    }
    private Set<Pair<Integer,List<Pair<K,V>>>> set = new LinkedHashSet<>();

    private List<Pair<K,V>> getList(K k) {
        int hash = k.hashCode();
        for (Pair<Integer,List<Pair<K,V>>> s : set) {
            if (s.getK() == hash) {
                return s.getV();
            }
        }
        List<Pair<K,V>> list = new ArrayList<>();
        Pair<Integer,List<Pair<K,V>>> pair = new Pair<>(hash, list);
        set.add(pair);
        return list;
    }
    
    private V insertValue(List<Pair<K, V>> list, K k, V v) {
        Pair<K, V> newPair = new Pair<>(k, v);
        for (int i = 0; i < list.size(); i++) {
            if (k.equals(list.get(i).getK())) {
                V returnVal =  list.get(i).getV();
                list.set(i, newPair);
                return returnVal;
            }
        }
        list.add(newPair);
        return null;
    }
                
    @Override
    public V put(K k, V v) {
        if (null == k) {
            throw new RuntimeException("Can't have a null key");
        }
        List<Pair<K, V>> list = getList(k);
        return insertValue(list, k, v);
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        // TODO Auto-generated method stub
        return false;
    }

    public V getFromList(Object k, List<Pair<K,V>> list) {
        for (Pair<K,V> pair : list) {
            if (k.equals(pair.getK())) {
                return pair.getV();
            }
        }
        return null;
    }

    
    public static void main(String[] args) {
        HashMap<String, Long> hm = new HashMap<>();
        
        AssertEquals(null, hm.put("foo",57l));
        AssertEquals(57l, hm.put("foo",58l));
        AssertEquals(58l, hm.get("foo"));
        
        AssertEquals(null, hm.put("bar",67l));
        AssertEquals(67l, hm.put("bar",68l));
        AssertEquals(68l, hm.get("bar"));
        AssertEquals(58l, hm.get("foo"));
    }
    
    private static void AssertEquals(Object o1, Object o2) {
        if (null == o1) {
            if (null != o2) {
                throw new RuntimeException(String.format("%s doesn't equal %s", o1, o2));
            } else {
                return;
            }
        }
        if (!o1.equals(o2)) {
            throw new RuntimeException(String.format("%s doesn't equal %s", o1, o2));
        }
    }

    @Override
    public V get(Object o) {
        if (null == o) {
            return null;
        }
        int hash = o.hashCode();
        for (Pair<Integer,List<Pair<K,V>>> pair : set) {
            if (pair.getK().equals(hash)) {
                return getFromList(o, pair.getV());
            }
        }
        return null;
    }

   

    @Override
    public V remove(Object key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Set<K> keySet() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<V> values() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        // TODO Auto-generated method stub
        return null;
    }
}