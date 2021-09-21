package org.sweatshop.tests;

public class Factorial {
	
	public static void main(String[] args) {
		Factorial factorial = new Factorial();
		System.out.println(factorial.factor(5));
	}

	private int factor(int i) {
		if (i < 1) {
			return 1;
		} else {
			return i * factor(i-1);
		}
	}

}
