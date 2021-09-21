package org.sweatshop.tests;

import static java.lang.String.format;

public class Nano {

    public static void main(String[] args) throws InterruptedException {
        long nanos1 = System.nanoTime();
        long milli1 = System.currentTimeMillis();

        System.out.println("nanos = " + nanos1 + ", length = " + String.valueOf(nanos1).length());
        System.out.println("milli = " + milli1 + ", length = " + String.valueOf(milli1).length());

        Thread.sleep(1000);

        long nanos2 = System.nanoTime();
        long milli2 = System.currentTimeMillis();

        long nanoDelta = nanos2 - nanos1;
        long millDelta = milli2 - milli1;

        System.out.println(format("nanodelta = %s, millidelta = %s, nanoDeltaLength = %s, millDeltaLength = %s"
                , nanoDelta, millDelta, String.valueOf(nanoDelta).length(), String.valueOf(millDelta).length()));

    }
}
