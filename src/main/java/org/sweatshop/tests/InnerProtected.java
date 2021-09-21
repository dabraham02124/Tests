package org.sweatshop.tests;

public class InnerProtected {

    public static class Foo {
        protected void bar() {
            System.out.println("called foo!");
        }
    }


    public static void main(String[] args) {
        new Foo().bar();
    }
}
