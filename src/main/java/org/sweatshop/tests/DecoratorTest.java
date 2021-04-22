package org.sweatshop.tests;

import static java.lang.String.format;

import java.util.Date;

import io.vavr.collection.List;
import lombok.Value;

@Value
public class DecoratorTest {
    String foo;

    @Value
    public static class D2Test {
        DecoratorTest dt;
        String bar;
    }

    public static void main(String[] args) {
        run(1_000);
        run(10_000);
        run(50_000);
        run(100_000);
        run(1_000_000);
        run(10_000_000);
    }

    public static void run(int max) {

        Date d1 = new Date();

        List<DecoratorTest> list = List.empty();
        for (int i = 0; i < max; i ++) {
            list = list.prepend(new DecoratorTest(Integer.toString(i)));
        }

        Date d2 = new Date();

        List<D2Test> list2 = List.empty();
        for (DecoratorTest dt : list) {
            list2 = list2.prepend(new D2Test(dt, dt.getFoo()));
        }

        Date d3 = new Date();

        System.out.println(format("1 took %s ms, 2 took %s ms, for %s"
                , d2.getTime() - d1.getTime(), d3.getTime() - d2.getTime(), max));
    }
}
