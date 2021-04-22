package org.sweatshop.tests;

import java.io.StringWriter;
import java.util.function.BiConsumer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogbackTest {

    public static void main(String[] args) {
        log.error("this line has variations on the curly's {} [{}] ({}) { [{}] }","alpha", "beta", "gamma", 4);
        log.error("this line has too many variables and should stop at \"beta\" {} {}", "alpha", "beta", "gamma");
        log.error("this line has too many curly pairs and should have an extra after \"beta\" {} {} {}", "alpha", "beta");
        log.error("passing in a StringWriter {}", getSW());
        log.error("passing in a null {}", (StringWriter)null); 
        
        Exception e = getException(3);
        log.error("the following line has no text, but takes an exception");
        log.error("", e);
        log.error("the following line has one curly pair, and takes two variables, the second is an exception");
        log.error("foo = {}", "bar", e);
        
        getLogLambda().accept("alpha {}", "beta");
    }

    private static Object getSW() {
        return new StringWriter().append("foo").append("=").append("bar");
   }

    private static BiConsumer<String, String> getLogLambda() {
        return ((s, t) -> log.info(s,t));
    }

    private static Exception getException(int i) {
        if (0 == i) {
            return new Exception("fred");
        } else {
            return getException(i-1);
        }
    }
}
