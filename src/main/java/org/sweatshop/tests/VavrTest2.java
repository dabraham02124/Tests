package org.sweatshop.tests;

import static io.vavr.API.*;

import java.time.LocalDate;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.Tuple3;
import io.vavr.collection.List;
import io.vavr.match.annotation.Patterns;
import io.vavr.match.annotation.Unapply;
import lombok.Value;

@Patterns
public class VavrTest2 {
    
    static class Person {
        String name;
        List<Address> addresses;
        
        public Person(String name, List<Address> addresses) {
            this.name = name;
            this.addresses = addresses;
        }
        
        public String getName() { return name; }
        public List<Address> getAddresses() { return addresses; }
    }

    static class Address {
        String street;
        int number;
        
        public Address(String street, int number) {
            this.street = street;
            this.number = number;
        }
        
        public String getStreet() { return street; }
        public int getNumber() { return number; }
    }

    @Unapply
    static Tuple2<String, List<Address>> Person(Person person) {
        return Tuple.of(person.getName(), person.getAddresses());
    }

    @Unapply
    static Tuple2<String, Integer> Address(Address address) {
        return Tuple.of(address.getStreet(), address.getNumber());
    }

//    public static void main(String[] args) {
//        List<Person> people = getPeople();
//        for (Person p : people) {
//            Match(p).of(
//                    Case($(p2 -> p2.name.equals("fred")), "fred"),              //this line compiles
//                    Case(Person($("fred"), $()), (name, addresses) -> format("$s lives at $s", name, addresses)),
//                    Case(Person("Carl", List.of(Address($("pine"), 1), Address($("south"), 2))), (name, addresses) -> ""),
//                    Case($(), "?")                                              //this line compiles
//                );
//        }
//    }

    private static List<org.sweatshop.tests.VavrTest2.Person> getPeople() {
        return List.of(
                new Person("fred",List.of(new Address("main", 1), new Address("south", 2))),
                new Person("barney",List.of(new Address("broadway", 3), new Address("pine", 4), new Address("elm", 5))),
                new Person("wilma",List.of(new Address("north", 6))),
                new Person("betty",List.empty())
                );
    }
    
}
