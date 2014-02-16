package org.sweatshop.tests;

import java.util.Date;

public class StringBuilderVsConcat {
    
    public static void main (String[] args) {
        Integer count = 10000;
        
        String[] strings = new String[count];
        
        for (int i = 0; i < count; i++) {
            strings[i] = Integer.toString(i);
        }
        
        StringBuffer sb = new StringBuffer();

        String output1 = new String();
        
        Date d1 = new Date();
        
        for (int i = 0; i < count; i++) {
            output1 += strings[i];
        }
        System.out.println(output1);
        
        
        Date d2 = new Date();
        
        for (int i = 0; i < count; i++) {
            sb.append(strings[i]);
        }
        System.out.println(sb.toString());
        
        
        Date d3 = new Date();
        
        System.out.println("string addition took "+(d2.getTime()-d1.getTime()));
        System.out.println("string addition took "+(d3.getTime()-d2.getTime()));
        
        
        
    }

}
