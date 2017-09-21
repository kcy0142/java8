package this_is_java.chap16.src.sec03.stream_pipelines;

import java.util.Arrays;
import java.util.List;

public class StreamPipelinesExample {
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
				new Member("test1", Member.MALE, 30),
				new Member("test2", Member.FEMALE, 20),
				new Member("test3", Member.MALE, 45),
				new Member("test4", Member.FEMALE, 27)
		);
		
		double ageAvg =   list.stream()
			.filter(m -> m.getSex()==Member.MALE)
			.mapToInt(Member :: getAge)
			.average()
			.getAsDouble();
		
		System.out.println("====tester: " + ageAvg);
	}
}


