package org.sweatshop.tests;

import lombok.AllArgsConstructor;

public class Equals {

    @AllArgsConstructor
    public static class Foo {
        Integer foo;
        String bar;
    }
    
    public static void main(String[] args) {
        Foo foo1 = new Foo(5, "five");
        Foo foo2 = new Foo(5, "five");
        
        if (foo1.equals(foo2)) {
            System.out.println("foo1 equals foo2");
        } else {
            System.out.println("foo1 does not equal foo2");
        }
    }
}
