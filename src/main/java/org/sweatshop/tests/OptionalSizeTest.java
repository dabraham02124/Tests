package org.sweatshop.tests;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.Getter;
import lombok.Value;

@Value
public class OptionalSizeTest {
	
	static int length = 10_000_000;
	static boolean optional = false;
	
	public static void main(String[] args) {
		if (optional) {
			List<Optional<ThatClass>> list = getOptionalList();
			System.out.println(String.format("Memory used with Optionals for list of size %s is %s"
					, list.size()
					, getSizeString()));
		} else {
			List<ThatClass> list = getIntegerListWithNulls();
			System.out.println(format("Memory used with bare class for list of size %s is %s"
					, list.size()
					, getSizeString()));
		}
	}

	private static String getSizeString() {
		long bytes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (bytes > 1048576) {
			return format("%s M", (long)bytes/1048576);
		}
		if (bytes > 1024) {
			return format("%s K", (long)bytes/1024);
		}
		return format("%s bytes", bytes);
	}

	private static List<ThatClass> getIntegerListWithNulls() {
		List<ThatClass> list = new ArrayList<>(length);
		
		for (int i = 0; i < length; i+=2) {
			list.add(new ThatClass(i));
			list.add(null);
		}
		return list;
	}

	private static List<Optional<ThatClass>> getOptionalList() {
		List<Optional<ThatClass>> list = new ArrayList<>(length);
		
		for (int i = 0; i < length; i+=2) {
			list.add(Optional.of(new ThatClass(i)));
			list.add(Optional.empty());
		}
		return list;
	}
	
	private static class ThatClass {
		@Getter private final String s;
		@Getter private final Integer i;
		
		public ThatClass(Integer i) {
			this.s = String.valueOf(i);
			this.i = i;
		}
	}

}
