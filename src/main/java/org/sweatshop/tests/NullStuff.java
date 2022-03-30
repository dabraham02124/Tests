package org.sweatshop.tests;

public class NullStuff {

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        System.out.println(((Integer)null).compare(4,5));
        
        String foo = (String) getNull();
        Integer bar = (Integer) getNull();
        
        System.out.println("equals " + (((Object)foo) == ((Object) bar)));
    }

    private static Object getNull() {
        return null;
    }

}
