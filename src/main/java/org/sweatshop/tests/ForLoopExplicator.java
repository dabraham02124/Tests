package org.sweatshop.tests;

public class ForLoopExplicator {

    public static void main(String[] args) {
        for (System.out.println("init");doBool();doUpdate()) {
            System.out.println("body");
        }
    }

    private static void doUpdate() {
        System.out.println("update");
    }

    private static Boolean doBool() {
        System.out.println("bool");
        return (i++ < 3);
    }
    
    static int i = 0;
    
    
}
