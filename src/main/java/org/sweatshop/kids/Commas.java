package org.sweatshop.kids;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Commas {

    public static String commas(String s) {
        if (null == s) {
            return "";
        }
        int length = s.length();
        log.trace("length {}", length);

        for (int i = 3; i <= length - 1; i += 3) {
            s = s.substring(0, length - i) + "," + s.substring((length - i));
        }
        
        return s;
    }

    
//    private static String commas2(String s) {
//        int length = s.length();
//        int times = (length-1)/3;
//        log.trace("length {}, times {}", length, times);
//        
//        for (int i = 1; i <= times; i++) {
//            log.trace("length {}, times {}, i {}", length, times, i);
//            s = s.substring(0, length - (i * 3)) + "," + s.substring((length - (i * 3)));
//        }
//        
//        return s;
//    }

}
