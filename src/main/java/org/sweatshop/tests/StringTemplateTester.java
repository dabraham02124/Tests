package org.sweatshop.tests;

import org.stringtemplate.v4.*;

public class StringTemplateTester{
    public static void main(String[] args) {
        ST hello = new ST("<Hello>, $name$", '$', '$');
        hello.add("name", "World");
        System.out.println(hello.render());
    }
}