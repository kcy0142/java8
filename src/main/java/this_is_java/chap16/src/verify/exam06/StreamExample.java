package this_is_java.chap16.src.verify.exam06;

import java.util.Arrays;
import java.util.List;

public class StreamExample {
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
			new Member("ȫ�浿", 30),
			new Member("�ſ��", 40),
			new Member("���ڹ�", 26)
		);
		
		double avg = list.stream()
			.mapToInt(Member::getAge)
			.average()
			.getAsDouble();
		
		System.out.println("��� ����: " + avg);
	}
	
	static class Member {
		private String name;
		private int age;
		
		public Member(String name, int age) {
			this.name = name;
			this.age = age;
		}
		
		public String getName() { return name; }
		public int getAge() { return age; }
	}
}
