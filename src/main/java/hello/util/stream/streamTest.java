
package hello.util.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class streamTest {

	
	//http://palpit.tistory.com/651
	public static void main(String[] args) {
		
		int[] intArr = {5, 4, 3, 2, 1};
        
        System.out.println("[peek()를 마지막에 호출한 경우]");
        Arrays.stream(intArr)
            .filter(a -> a % 2 == 0)
            .peek(n -> System.out.println(n));    // 동작하지 않음
        
        System.out.println("[최종 처리 메소드를 마지막에 호출한 경우]");
        int total = Arrays.stream(intArr)
                .filter(a -> a % 2 == 0) 
                .peek(n -> System.out.println(n))    // 동작함
                .sum();
        System.out.println("총합: " + total);
        
        System.out.println("[forEach를 마지막에 호출한 경우]");
        Arrays.stream(intArr)
            .filter(a -> a % 2 == 0)
            .forEach(n -> System.out.println(n)); // 최종 메소드로 동작함
        
        System.out.println("==========================================");
        
        int[] intArr1 = {2, 4, 6, 8, 10, 12};
        
        boolean result = Arrays.stream(intArr1)
                .allMatch(a -> a % 2 == 0);
        System.out.println("모두 2의 배수 인가 ? " + result);
        
        result = Arrays.stream(intArr1)
                .anyMatch(a -> a % 3 == 0);
        System.out.println("하나라도 3의 배수가 있는가 ? " + result);
        
        result = Arrays.stream(intArr1)
                .noneMatch(a -> a % 5 == 0);
        System.out.println("5의 배수가 없는가 ? " + result);
        
        System.out.println("==========================================");
        
        int[] intArr2 = {5, 8, 11, 13, 19, 20, 24};
        long count = Arrays.stream(intArr2)
                .filter( n -> n % 2 == 0)
                .count();
        System.out.println("2의 배수 개수: " + count);
        
        long sum = Arrays.stream(intArr2)
                .filter( n -> n % 2 == 0)
                .sum();
        System.out.println("2의 배수의 합: " + sum);
        
        double avg = Arrays.stream(intArr2)
                .average()
                .getAsDouble();
        System.out.println("배열의 평균; " + avg);
        
        int third = Arrays.stream(intArr2)
                .filter(n -> n % 3 == 0)
                .findFirst()
                .getAsInt();
        System.out.println("3의 배수: " + third);
        
        System.out.println("==========================================");
        List<Integer> list = new ArrayList<>();

        double avg3 = list.stream()
        	    .mapToInt(Integer :: intValue)
        	    .average()
        	    .orElse(0.0);
        	 
        System.out.println("평균: " + avg3);




        




	}

	
}

