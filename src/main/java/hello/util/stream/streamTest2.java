
package hello.util.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class streamTest2 {

	
	//http://jdm.kr/blog/181
	public static void main(String[] args) {
		
		Arrays.asList(1,2,3).stream().forEach(System.out::println); // 1,2,3

		
		Arrays.asList(1,2,3).stream()
		.map(i -> i*i)
		.forEach(System.out::println); // 1,4,9

		//stream의 최초 요소부터 선언한 인덱스까지의 요소를 추출해 새로운 stream을 만듭니다
		Arrays.asList(1,2,3).stream()
		.limit(1)
		.forEach(System.out::println); // 1
		
		//stream의 최초 요소로부터 선언한 인덱스까지의 요소를 제외하고 새로운 stream을 만듭니다
		Arrays.asList(1,2,3).stream()
		.skip(1)
		.forEach(System.out::println); // 2,3
		
		//stream의 요소마다 비교를 하고 비교문을 만족하는 요소로만 구성된 stream을 반환합니다. 
		
		Arrays.asList(1,2,3).stream()
		.filter(i-> 2>=i)
		.forEach(System.out::println); // 1,2
		
		//stream의 내부에 있는 객체들을 연결한 stream을 반환합니다. 
		
		Arrays.asList(Arrays.asList(1,2),Arrays.asList(3,4,5),Arrays.asList(6,7,8,9)).stream()
		.flatMap(i -> i.stream())
		.forEach(System.out::println); // 1,2,3,4,5,6,7,8,9
		
		//stream을 단일 요소로 반환합니다. 
		Arrays.asList(1,2,3).stream()
		.reduce((a,b)-> a-b)
		.get(); // -4
		
		Arrays.asList(1,2,3).stream()
		.collect(Collectors.toList());
		
		Arrays.asList(1,2,3).stream()
		.iterator();
		
		
	}

	
}

