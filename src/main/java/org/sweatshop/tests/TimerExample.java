package org.sweatshop.tests;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerExample extends TimerTask {

    @Override
    public void run() {
        System.out.println(new Date());
    }

    public static void main(String[] args) {
        TimerTask tt = new TimerExample();
        Timer t = new Timer(true);
        t.scheduleAtFixedRate(tt, new Date(), 1_000);

        System.out.println("TimerTask started");
        //cancel after sometime
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.cancel();
        System.out.println("TimerTask cancelled "+new Date());
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
