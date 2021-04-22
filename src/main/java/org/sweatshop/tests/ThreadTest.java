package org.sweatshop.tests;

public class ThreadTest {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            prints("i =", foo());
        });
        System.out.println("middle");
        t.run();
    }
    
    public static void prints(String... strings) {
        for (String s : strings) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
    
    public static String foo() {
        Integer i = 7;
        i += 4;
        return i.toString();
    }
}
