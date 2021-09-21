package org.sweatshop.tests;

import static java.lang.String.format;

public class Timers {

    public static final float N = 10_0000_000;

    public static void main(String[] args) {
        testMilli();
        testNanos();
        testMilli();
        testNanos();
        testMilli();
        testNanos();
    }

    static void testMilli() {
        long sum = 0;
        long t1 = System.nanoTime();
        for (int i = 0; i < N; i++) {
            sum += System.currentTimeMillis();
        }
        long t2 = System.nanoTime();
        System.out.println(format("mils Sum = %30s, time = %d or %,.2f ns / iter", sum , (t2 - t1), (t2 - t1) / N));
    }

    static void testNanos() {
        long sum = 0;
        long t1 = System.nanoTime();
        for (int i = 0; i < N; i++) {
            sum += System.nanoTime();
        }
        long t2 = System.nanoTime();
        System.out.println(format("nano Sum = %30s, time = %d or %,.2f ns / iter", sum , (t2 - t1), (t2 - t1) / N));
    }

}
