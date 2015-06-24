package org.sweatshop.tests;

import lombok.Value;

import com.google.gson.Gson;

@Value
public class GsonTest {
    private String foo;
    private Integer bar;
    private int baz;
    
    public static void main(String[] args) {
        GsonTest gt = new GsonTest("fooString", 17, 94);
        
        String json = new Gson().toJson(gt);
        
        System.out.println(json);
     
        GsonTest gt2 = new Gson().fromJson(json,GsonTest.class);
        
        if (gt.equals(gt2)) System.out.println("equals!");
    }
}
