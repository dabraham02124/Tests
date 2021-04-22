package org.sweatshop.tests;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Tester {

    private static List<String> createStringList() {
        List<String> stringList = new LinkedList<>();
        stringList.add("foo");
        stringList.add("bar");
        stringList.add("baz");
        stringList.add("qux");
        stringList.add("quux");
        stringList.add("quuux");
        return Collections.unmodifiableList(stringList);
    }

    private static List<Integer> createIntegerList() {
        List<Integer> intList = new LinkedList<>();
        intList.add(5);
        intList.add(6);
        intList.add(7);
        intList.add(8);
        intList.add(9);
        return Collections.unmodifiableList(intList);
    }


    private static void forEachTester() {
        createIntegerList().forEach((a) -> System.out.println(a*a));
    }

    public static void main(String[] args) {
        forEachTester();System.out.println();
        filterTester();System.out.println();
        mapTester();System.out.println();
        alterListInPlace();System.out.println();
    }

    private static void alterListInPlace() {
        List<String> stringList = new LinkedList<>();
        createStringList().forEach(s -> stringList.add(s));
        stringList.replaceAll(s -> s.toUpperCase());
        System.out.println(stringList);
    }

    private static void mapTester() {
        System.out.println(createIntegerList().stream().map(i -> i*i).collect(Collectors.toList()));

    }

    private static void filterTester() {
        createStringList().stream().filter(s -> s.length() > 3).forEach(s -> System.out.println(s));
    }
}
