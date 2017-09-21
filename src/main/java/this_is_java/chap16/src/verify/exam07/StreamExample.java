package this_is_java.chap16.src.verify.exam07;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
			new Member("ȫ�浿", "������"),
			new Member("�質��", "�����̳�"),
			new Member("�ſ��", "������")
		);
		
		List<Member> developers = list.stream()
			.filter(m -> m.getJob().equals("������"))
			.collect(Collectors.toList());
		
		developers.stream().forEach(m -> System.out.println(m.getName()));
	}
	
	static class Member {
		private String name;
		private String job;
		
		
		public Member(String name, String job) {
			this.name = name;
			this.job = job;
		}
		
		public String getName() { return name; }
		public String getJob() { return job; }
	}
}
