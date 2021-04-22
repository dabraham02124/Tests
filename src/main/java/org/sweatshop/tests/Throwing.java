package org.sweatshop.tests;

import static java.lang.String.format;

import java.nio.channels.UnsupportedAddressTypeException;
import java.util.Date;

public class Throwing {

    public static void main(String[] args) {
        int num = 10_000_000;
        
        Date d1 = new Date();
        System.out.println("about to throw UnsupportedOperationException");
        for (int i = 0; i < num; i++) {
            experiment1(new UnsupportedOperationException());
        }
        
        Date d2 = new Date();
        System.out.println("\nabout to throw UnsupportedAddressTypeException");
        for (int i = 0; i < num; i++) {
            experiment1(new UnsupportedAddressTypeException());
        }
        
        Date d3 = new Date();
        System.out.println("\nabout to throw UnsupportedOperationException");
        for (int i = 0; i < num; i++) {
            experiment2(new UnsupportedOperationException());
        }
        
        Date d4 = new Date();
        System.out.println("\nabout to throw UnsupportedAddressTypeException");
        for (int i = 0; i < num; i++) {
            experiment2(new UnsupportedAddressTypeException());
        }
        
        Date d5 = new Date();
        System.out.println(format("1 took %s, 2 took %s, 3 took %s, 4 took %s"
                , d2.getTime() - d1.getTime()
                , d3.getTime() - d2.getTime()
                , d4.getTime() - d3.getTime()
                , d5.getTime() - d4.getTime()));
    }

    private static void experiment2(Exception exception) {
        try {
            try {
                throw exception;
            } catch (Exception e) {
                if (exception instanceof UnsupportedOperationException) {
                    sop("caught UnsupportedOperationException, rethrowing");
                } else {
                    sop("caught Exception, rethrowing");
                }
                throw e;
            }
        } catch (Exception e) {
            //this catch block intentionally left empty
        }
    }

    @SuppressWarnings("unused")
    private static void sop(String string) {
//        System.out.println(string);
    }

    private static void experiment1(Exception exception) {
        try {
            try {
                throw exception;
            } catch (UnsupportedOperationException e) {
                sop("caught UnsupportedOperationException, rethrowing");
                throw e;
            } catch (Exception e) {
                sop("caught Exception, rethrowing");
                throw e;
            }
        } catch (Exception e) {
            //this catch block intentionally left empty
        }
    }
    
}
