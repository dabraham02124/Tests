package org.sweatshop.tests;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringJoinerTest {
    
    public static void main(String[] args) {
        final List<String> strings = Arrays.asList("Foo", "Bar", "Baz", "Qux");
        
        final String collectJoin = strings.stream().collect(Collectors.joining(" d ", " p ", " s "));
        
        System.out.println(collectJoin);
    }

}
