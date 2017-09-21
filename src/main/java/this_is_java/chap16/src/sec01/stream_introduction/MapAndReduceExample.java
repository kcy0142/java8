package this_is_java.chap16.src.sec01.stream_introduction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MapAndReduceExample {
	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(
				new Student("test1", 10),
				new Student("test2", 20),
				new Student("test3", 30)
		);		
			
		/*Stream<Student> stream = list.stream();
		stream.forEach(s -> {
			String name = s.getName();
			int score = s.getScore();
			System.out.println(name + "-" + score);
		});*/
		double avg = studentList.stream()
			//�߰�ó��(�л� ��ü�� ������ ����)
			.mapToInt(s->s.getScore())
			//	.mapToInt(Student :: getScore)
			//���� ó��(��� ����)
			.average()
			.getAsDouble();
		
		System.out.println("avage: " + avg);
	}
}
