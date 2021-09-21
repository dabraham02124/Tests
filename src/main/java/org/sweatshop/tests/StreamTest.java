package org.sweatshop.tests;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        String string = "foo bar baz  qux   quux";
        List<String> l1 = Arrays.asList(string.split(" "));
        List<String> l2 = Arrays.asList(string.split(" ")).stream().filter(s -> !"".equals(s)).collect(Collectors.toList());

        System.out.println("l1 = "+l1);
        System.out.println("l2 = "+l2);
    }

}
