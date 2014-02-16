package org.sweatshop.tests;

public class VarArgsTester {


    
    private static void printVarArgs(String sOne) {
        System.out.println("only one "+sOne);
    }

    
    private static void printVarArgs(String sOne, String... args) {
        System.out.print(sOne+" ");
        
        for (String arg : args) {
            System.out.print(arg+" ");
        }
        System.out.println();
    }
    
    
    public static void main(String[] args) {
        printVarArgs("foo", "bar", "baz");
        printVarArgs("foo", "bar");
        printVarArgs("foo");
//        printVarArgs();
        printVarArgs((String)null);
        printVarArgs((String)null, (String)null);
        printVarArgs("foo", null, "baz");
        printVarArgs("foo", "bar", null);
    }
}
