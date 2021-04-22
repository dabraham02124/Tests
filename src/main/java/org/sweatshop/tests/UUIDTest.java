package org.sweatshop.tests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UUIDTest {

	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		System.out.println(String.format("into main %s", uuid));

		for (int i = 0; i < 10; i++) {
			test(10_000_000);
		}
	}
	
	private static void test(int iterations) {
		Date d1 = new Date();
		runTimingTest(iterations);
		Date d2 = new Date();
		
		long delta = d2.getTime()-d1.getTime();
		float perSecond = iterations *1000 / delta;
		System.out.println(String.format("it took %s ms for %s iterations for %s per second (and checking if format is null safe -- %s --)"
				, delta, iterations, perSecond, null));
	}
	
	
	private static void runTimingTest(int iterations) {
		final List<UUID> list = new ArrayList<UUID>(iterations);
		
		for (int i = 0; i < iterations; i++) {
			list.add(UUID.randomUUID());
		}
		
		System.out.println(list.size());
	}
	
}
