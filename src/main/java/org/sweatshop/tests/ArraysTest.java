package org.sweatshop.tests;

import static java.lang.String.format;

import java.util.List;

public class ArraysTest {

    public static void main(String[] args) {
         List<String> list = java.util.Arrays.asList((String[])null);
         if (null == list) {
             System.out.println("null");
         } else {
             System.out.println(format("size = %s", list.size()));
         }
    }
}
