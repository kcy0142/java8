package this_is_java.chap16.src.sec06.stream_sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class SortingExample {
	public static void main(String[] args) {
		//���� ����� ���
		IntStream intStream = Arrays.stream(new int[] {5, 3, 2, 1, 4});
		intStream
			.sorted()
			.forEach(n -> System.out.print(n + ","));
		System.out.println();
		
		//��ü ����� ���
		List<Student> studentList = Arrays.asList(
			new Student("test1", 30),
			new Student("test2", 10),
			new Student("test3", 20)
		);
		
		studentList.stream()
			.sorted( )
			.forEach(s -> System.out.print(s.getScore() + ","));
		System.out.println();
		
		studentList.stream()
		.sorted( Comparator.reverseOrder() )
		.forEach(s -> System.out.print(s.getScore() + ","));	
	}
}
