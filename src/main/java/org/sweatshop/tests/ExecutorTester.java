package org.sweatshop.tests;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorTester {
    ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) throws InterruptedException {
        new ExecutorTester().doTheThing();
        Thread.sleep(10_000);
    }

    private void doTheThing() {
        scheduler.scheduleAtFixedRate(() -> System.out.println(new Date()), 0, 0, TimeUnit.SECONDS);
    }
}
