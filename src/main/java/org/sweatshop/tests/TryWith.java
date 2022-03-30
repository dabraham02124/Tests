package org.sweatshop.tests;

public class TryWith {

    public static void main(String[] args) throws Exception {
        try (AC foo = AC.foo()) {
            System.out.println("in try with, foo = "+foo);
        } finally {
            System.out.println("in finally");
        }
    }
    public static class AC implements AutoCloseable {

        @Override
        public void close() throws Exception {
            System.out.println("closing");
        }

        public static AC foo() {
            return null;//throw new RuntimeException("arugula");
        }
        
    }
}
