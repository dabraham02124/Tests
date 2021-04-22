package org.sweatshop.tests;

public class EnumTester {

    private static enum EnumType {
        ALPHA,
        BETA,
        GAMMA;

        @Override public String toString() {
            return "aooga";
        }
    }

    public static void main(String[] args) {
        for (EnumType e : EnumType.values()) {
            System.out.println("toString = "+e.toString());
            System.out.println("name = "+e.name());
            System.out.println("valueOf = "+String.valueOf(e));
            System.out.println();
        }

    }


}
