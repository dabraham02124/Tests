package org.sweatshop.tests;

import java.util.ArrayList;
import java.util.List;

public class MethodCasting {
    
    private static class Foo {
        public String getString() { return "Foo";}
    }
    
    private static class Bar extends Foo {
        public String getString() { return "Bar";}
    }
    
    public static void main(String[] args) {
        System.out.println((((Foo) new Bar()).getString()));
        
//        Foo[] foos ={ new Bar()};
        List<Foo> list = new ArrayList<>(); list.add(new Bar());
    }
}
