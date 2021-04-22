package org.sweatshop.tests;

import java.util.Optional;

public class OptionalTest {
    
    public static void main(String[] args) {
        Optional<String> o1 = Optional.of("foo");
        Optional<String> o2 = Optional.empty();
        
        test(o1);
        test(o2);
    }

    private static void test(Optional<String> o) {
        String s = o.map(v -> v+v).orElse("spam");
        System.out.println(s);
    }

}
