package org.sweatshop.tests;

public class FB {

    public static void main(String[] args) {
        fizzBuzz(3,5,34);
    }

    private static void fizzBuzz(int fizz, int buzz, int top) {
        for (int i = 1; i < top; i++) {
            boolean mod = false;
            if (i % fizz == 0) {
                System.out.print("fizz");
                mod = true;
            }
            if (i % buzz == 0) {
                System.out.print("buzz");
                mod = true;
            }
            if (mod) {
                System.out.println();
            } else {
                System.out.println(i);
            }
            
        }
    }
    
}
