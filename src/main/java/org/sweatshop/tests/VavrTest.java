package org.sweatshop.tests;

import static io.vavr.API.*;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.Tuple3;

import static io.vavr.API.$;

import io.vavr.collection.Iterator;
import io.vavr.collection.List;
import io.vavr.match.annotation.*;
import lombok.Value;

import java.time.LocalDate;
import java.util.Arrays;;

@Patterns
public class VavrTest {
//
//    @Value
//    public static class Address {
//        String street;
//    }
//
//    @Value
//    public static class Person {
//        String name;
//        List<Address> addresses;
//
//        public boolean hasAddress() { return 0 != addresses.length(); }
//        
//    };
//    @Unapply
//    static Tuple2<String, List<Address>> Person(Person p) {
//        return Tuple.of(p.name, p.addresses);
//    }
//
//    @Unapply
//    static List<Address> Addresses(String... as) {
//        return List.ofAll(Arrays.asList(as).stream().map(s -> new Address(s)));
//    }
//
//    public static void main(String[] args) {
//        List<Person> persons = getPerson();
//
//        Iterator<String> iterator =
//                For(persons.filter(Person::hasAddress), p ->
//                        For(p.addresses).yield(a ->
//                                p.name + "," + a.street
//                                )
//                        );
//        for (String s : iterator) {
//            System.out.println(s);
//        }
//        
//        for (int i = 0; i < 5; i++) {
//            System.out.print(i+ " -> ");
//            testMatch(i);
//        }
//        
//        
//        List<Integer> ints = List.ofAll(1,2,3,4);
//        int total = ints.fold(0, Integer::sum);
//        System.out.println(total);
//    }
//
//    private static void testMatch(int i) {
//        System.out.println(Match(i).of(
//                Case($(1), "one"),
//                Case($(2), "two"),
//                Case($(), "?")
//            ));
//    }
//
//
////    private static void testMatch(Person p) {
////        System.out.println(Match(p).of(
////                Case($(p2 -> p2.name.equals("fred")), "fred"),
////                Case(Person($("dred"), $(List.empty())), (name, addresses) -> "Carl has employee id "+id),
////                Case(Person($("fred"), $(List.empty())), (name, addresses) -> "one "+ name),
////                Case(Person("Carl", Addresses("one", "two")), (street, number) -> ""),
//////                Case($(2), "two"),
////                Case($(), "?")
////            ));
////    }
//
//    private static List<Person> getPerson() {
//        return List.of(
//                new Person("fred",List.of(new Address("main"), new Address("south"))),
//                new Person("barney",List.of(new Address("main"), new Address("south"), new Address("pine"))),
//                new Person("wilma",List.of(new Address("main"))),
//                new Person("betty",List.empty())
//                );
//    }
//    
//    
//    @Unapply
//    static Tuple3<Integer, Integer, Integer> LocalDate(LocalDate date) {
//        return Tuple.of(
//          date.getYear(), date.getMonthValue(), date.getDayOfMonth());
//    }
//    
//    
//    
//
////    public void givenObject_whenDecomposesVavrWay_thenCorrect2() {
////        LocalDate date = LocalDate.of(2017, 2, 13);
////     
////        String result = Match(date).of(
////          Case(LocalDate($(2016), $(3), $(13)), 
////            () -> "2016-02-13"),
////          Case(LocalDate($(2016), $(), $()),
////            (y, m, d) -> "month " + m + " in 2016"),
////          Case(LocalDate($(), $(), $()),  
////            (y, m, d) -> "month " + m + " in " + y),
////          Case($(), 
////            () -> "(catch all)")
////        );
////     
////    }
}
