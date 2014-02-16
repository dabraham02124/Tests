package org.sweatshop.tests;

public class EqualityTester {
    
    private static void setAndTestEquality (int i) {
        Integer i1;
        Integer i2;
        
        i1 = new Integer(i);
        i2 = new Integer(i);
        System.out.println(i1 == i2);
        
        i1 = i;
        i2 = i;
        System.out.println(i1 == i2);
    }
    
    public static void main (String[] args) {
        setAndTestEquality(17);
        setAndTestEquality(700);
        
        
        
    }

}
