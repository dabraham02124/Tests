package org.sweatshop.tests;

import java.io.PrintWriter;
import java.io.StringWriter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogExample {

    
    public static void main(String[] args) {
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            log.error("foo {}", "bar", e);
            log.error(null);
            
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String sStackTrace = sw.toString();
            log.error("foo {}\n{}", "bar", sStackTrace);
        }
        
        
        
        
        
    }
}
