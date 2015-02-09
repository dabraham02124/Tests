package org.sweatshop.tests;

public class AutoBoxing {

    public static void foo(int bar) {
        System.out.println(bar);
    }
    
    public static void main(String[] args) {
        foo((Integer) null);
    }
    
}
