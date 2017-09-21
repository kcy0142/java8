package this_is_java.chap16.src.verify.exam08;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExample {
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
			new Member("ȫ�浿", "������"),
			new Member("�質��", "�����̳�"),
			new Member("�ſ��", "������")
		);
		
		Map<String, List<String>> groupingMap = list.stream()
			.collect(
				Collectors.groupingBy(
					Member::getJob, 
					Collectors.mapping(Member::getName, Collectors.toList())
				)
			); 

		System.out.print("[������] ");
		groupingMap.get("������").stream().forEach(s -> System.out.print(s + " "));
		System.out.print("\n[�����̳�] ");
		groupingMap.get("�����̳�").stream().forEach(s -> System.out.print(s + " "));
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
