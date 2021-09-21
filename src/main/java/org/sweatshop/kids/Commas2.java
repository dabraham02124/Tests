package org.sweatshop.kids;

public class Commas2 {

    public static String commasWithDecimal(String in) {
        if (null == in) {
            return "";
        }
        int decimal = in.indexOf(".");
        if (-1 == decimal) {
            return Commas.commas(in);
        } else {
            return Commas.commas(in.substring(0, decimal)) + in.substring(decimal);
        }
    }
    
    public static String commasBothWaysWithDecimal(String in) {
        if (null == in) {
            return "";
        }
        int index = in.indexOf(".");
        if (-1 == index) {
            return Commas.commas(in);
        } else {
            return Commas.commas(in.substring(0, index)) + "." + reverseString(Commas.commas(reverseString(in.substring(index+1))));
        }
        
    }
    
    public static String reverseString(String str) {  
        if (null == str) {
            return "";
        } else {
            return new StringBuilder(str).reverse().toString();
        }
    }  
}
