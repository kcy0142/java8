package this_is_java.chap16.src.sec01.stream_introduction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelExample {	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("test1", "test2", "test3", "test4", "test5");
		
		//���� ó��
		Stream<String> stream = list.stream();
		stream.forEach(ParallelExample :: print);
		
		System.out.println();
		
		//���� ó��
		Stream<String> parallelStream = list.parallelStream();
		parallelStream.forEach(ParallelExample :: print);
	}
	
	public static void print(String str) {
		System.out.println(str+ " : " + Thread.currentThread().getName());
	}	
}
