package org.sweatshop.tests;

public class TypeInferenceTest {
    public static void main(String[] args) {
      (new Object() { 
        public void bar() { 
          System.out.println("bar!"); 
       } 
      }).bar();
    }
  }
