package org.sweatshop.tests;

public class FinallyTester {

    private static final boolean returnTrue() {
        return true;
    }

    public static void main(String[] args) throws Exception {
        try {
            if (returnTrue()) {
                throw new Exception("foooo");
            }
        } finally {
            System.out.println("in finally\n");
        }
        System.out.println("after finally");
    }

}
