package org.sweatshop.tests;

import java.util.stream.IntStream;

import io.vavr.Tuple;
import io.vavr.collection.List;

public class FizzBuzz {

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100).mapToObj(i -> fb(i)).forEach(System.out::println);
        
        System.out.println("----------------------");
        
        List.rangeClosed(1, 100)
        .map(i -> ((i % 3) == 0) ? Tuple.of(i, "fizz") : Tuple.of(i, ""))
        .map(t -> (t._1 % 5 == 0) ? Tuple.of(t._1, t._2 +"buzz") : t)
        .map(t -> t._2.equals("") ? t._1 : t._2)
        .forEach(s -> System.out.println(s));;
        
    }

    private static String fb(int i) {
        if (i % 15 == 0) {
            return "fizzbuzz";
        } else if (i % 3 == 0) {
            return "fizz";
        } else if (i % 5 == 0) {
            return "buzz";
        } else {
            return String.valueOf(i);
        }
    }
    
    
}
