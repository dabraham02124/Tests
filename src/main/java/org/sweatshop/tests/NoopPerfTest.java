package org.sweatshop.tests;

import static java.lang.String.format;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class NoopPerfTest {

    private static interface Nooper {
        void noop();
        
        void noop2(int i);
    }
    
    private static class NooperImpl implements Nooper {
        @Override public void noop() { /* do nothing */ }
        
        private static final boolean logOutput = false;
        
        @Override public void noop2(int i) {
            String s = "fred" +i;
            if (logOutput) {
                System.out.println(s);
            }
        }
    }
    
    public static void main(String[] args) {
        List<Nooper> list = new ArrayList<>(10);
        IntStream.range(0, 10).forEach(i -> list.add(new NooperImpl()));
        
        OffsetDateTime odt1 = OffsetDateTime.now();
        
        int iterations = 100_000_000;
        for (int i = 0; i < iterations; i++) {
            final int i2 = i;
            list.stream().forEach(n -> n.noop2(i2));
        }
        
        OffsetDateTime odt2 = OffsetDateTime.now();
        
        Duration d = Duration.between(odt1, odt2);
        
        DecimalFormat formatter = new DecimalFormat("#,###");
        System.out.println(format("%s iterations took %s long at %s per", formatter.format(iterations), d, d.dividedBy(iterations)));
    }
}
