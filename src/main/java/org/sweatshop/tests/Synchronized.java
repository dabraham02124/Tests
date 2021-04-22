package org.sweatshop.tests;

import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Value;

public class Synchronized {

    private static void wait5s(Date d) throws InterruptedException {
        synchronized(d) {
            Thread.sleep(5_000);
            System.out.println(new Date().getTime() - d.getTime());
        }
    }

    @Value
    @EqualsAndHashCode(callSuper=false)
    private static class MyThread extends Thread {
        Date d;
        @Override public void run() {
            try {
                wait5s(d);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Date d = new Date();
        new MyThread(d).start();
        new MyThread(d).start();
        new MyThread(d).start();
    }
}
