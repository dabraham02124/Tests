package org.sweatshop.tests;

import java.io.IOException;
import java.time.OffsetTime;

import lombok.Value;

public class Timer {

    @Value
    private static class Config {
        int activity;
        int rest;
        int reps;
    }
    
    public static final Runtime rt = Runtime.getRuntime();
    public static final int thousand = 1_000;
    
    
    public static void main(String[] args) throws InterruptedException, IOException {
        
        int i = 2;
        
        switch(i) {
            case 0 : go(new Config(8, 8, 10)); break;
            case 1 : go(new Config(8, 2, 10)); break;
            case 2 : go(new Config(8, 4, 5)); break;
        }
    }
    
    public static void go(Config config) throws InterruptedException, IOException {
        beep(5);
        for (int i = 0; i < config.getReps(); i++) {
            if (0 == i ) {
                beep("start");
            } else {
                beep(String.valueOf(i+1));
            }
            sleep(config.getActivity());
            if (i < config.getReps() - 1) {
                beep("rest");
                System.out.println("--------------");
                sleep(config.getRest());
            }
        }
        beep("done");
    }
    
    private static void beep(int times) throws InterruptedException, IOException {
        for (int i = times; i > 0; i--) {
            rt.exec("say "+ i);
            Thread.sleep(thousand);
        }
    }

    private static void beep(String saying) throws IOException {
//        java.awt.Toolkit.getDefaultToolkit().beep();
        rt.exec("say "+ saying);
        System.out.println(OffsetTime.now());
    }

    static void sleep(int seconds) throws InterruptedException {
        Thread.sleep(seconds * thousand);
    }

}
