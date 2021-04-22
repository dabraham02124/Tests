package org.sweatshop.tests;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Value;

public class StackTimings {
    private static final int iterations = 10_000;

    public static void main(String[] args) {
        //this is here to get the jvm up and running so as to not affect the timings.
        //without this, the 1 depth took _noticeably_ longer than the 10 or 100
        System.out.println(callLots(1000));

        final List<DepthAndDates> list = new ArrayList<>();
        list.add(callLots(1));
        list.add(callLots(10));
        list.add(callLots(100));
        list.add(callLots(500));
        list.add(callLots(1_000));
        list.add(callLots(5_000));
        list.add(callLots(10_000));

        System.out.println(format("\n\n\nStack Depth\t\tTime in MS for %s iterations", iterations));
        for (DepthAndDates d : list) {
            System.out.println(format("%s\t\t\t%s",d.getDepth(), d.getPod().getDiff()));
        }
    }

    @Value
    private static class DepthAndDates {
        int depth;
        PairOfDates pod;
    }

    private static DepthAndDates callLots(final int depth) {
        final Date d1 = new Date();
        for (int i = 0; i < iterations; i++) {
            //this exists purely so that JIT doesn't optimize this call away entirely
            System.out.println(stackCall(depth,0, i));
        }
        return new DepthAndDates(depth, new PairOfDates(d1, new Date()));
    }

    @Value
    private static class PairOfDates {
        Date d1;
        Date d2;
        public long getDiff() {
            return d2.getTime() - d1.getTime();
        }
    }
    private static boolean getTrue() { return true; }
    private static int stackCall(final int maxDepth, final int depth, final int in) {
        if (maxDepth <= depth) {
            if (getTrue()) { //this is here to make it harder to compile away
                return 2*in;
            } else {
                return in;
            }
        } else {
            return stackCall(maxDepth, depth+1, in);
        }
    }
}
