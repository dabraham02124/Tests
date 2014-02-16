package org.sweatshop.tests;

import com.google.gson.Gson;

public class GsonTest {
    
    private String foo;
    private Integer bar;
    private int baz;
    
    
    public static void main(String[] args) {
        GsonTest gt = new GsonTest();
        gt.foo = "fooString";
        gt.bar = 17;
        gt.baz = 94;
        
        String json = new Gson().toJson(gt);
        
        System.out.println(json);
     
        GsonTest gt2 = new Gson().fromJson(json,GsonTest.class);
        
        if (gt.equals(gt2)) System.out.println("equals!");
        
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GsonTest) {
            GsonTest g2 = (GsonTest) obj;
            if (!foo.equals(g2.foo)) return false;
            if (!bar.equals(g2.bar)) return false;
            if (baz != (g2.baz)) return false;
            
        return true; 
        }
        return false;
        
    }
    

}
