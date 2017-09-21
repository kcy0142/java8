package this_is_java.chap16.src.sec04.stream_filtering;

import java.util.Arrays;
import java.util.List;

public class FilteringExample {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("test1", "tfst2", "tgst3", "test4", "tfst5");
		
		names.stream()
			.distinct()
			.forEach(n -> System.out.println(n));
		System.out.println();
		
		names.stream()
			.filter(n -> n.startsWith("te"))
			.forEach(n -> System.out.println(n));
		System.out.println();
		
		names.stream()
			.distinct()
			.filter(n -> n.startsWith("tf"))
			.forEach(n -> System.out.println(n));		
	}
}
