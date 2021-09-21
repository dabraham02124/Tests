package org.sweatshop.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lombok.NonNull;
import lombok.val;

public class NonNullTester {


    @SafeVarargs
    public static <T> List<T> list(T... items) {
        val list = new ArrayList<T>();
        for (T item : items) {
            list.add(item);
        }
        return list;
    }


    public static void main(String[] args) {

        List<String> l1 = Collections.unmodifiableList(Arrays.asList("foo", "bar", "baz"));
        List<String> l2 = new ArrayList<>(l1);
        l2.add("quz");

        System.out.println(l2);

        System.out.println(list());
//        System.out.println(getNull(null));
    }

    @NonNull private static String getNull(@NonNull String foo) {
        return null;
    }

}
