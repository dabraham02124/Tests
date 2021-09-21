package org.sweatshop.kids;

import java.util.stream.Collectors;

import io.vavr.collection.List;

public class Accountant {
	
	public static void main(String[] args) {
		List<String> words = List.of(
				"appoint", "coins", "countdown", "crowd", "rap", "noisy", "proud", "royal", "wrap", "voice");
		
		words
		    .map(s -> s.toLowerCase())
		    .forEach(w -> System.out.println(w 
					+ " = " 
					+ w.chars().boxed().map(n -> String.valueOf(n - 96)).collect(Collectors.joining(" + "))
					+ " = " 
					+ w.chars().map(n -> n - 'a' + 1).sum()
		));
		
		words
            .forEach(w -> System.out.format(
                    "%s = %s%n"
                    , w
                    , w.chars().map(n -> n - 'a' + 1).sum()
            ));
	}
}
