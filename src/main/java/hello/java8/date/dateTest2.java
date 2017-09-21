
package hello.java8.date;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class dateTest2 {

	
	//http://kwseo.github.io/java/2016/02/10/java8-about-date-2.html
	public static void main(String[] args) {
		
		  System.out.println("==================날짜 및 시간 객체 생성=======================");
		// 현재 날짜 및 시간 객체 생성
		  LocalDate today = LocalDate.now();
		  LocalDateTime now = LocalDateTime.now();
		  LocalTime currentTime = LocalTime.now();
		  
		  System.out.println("===now:"+now);
		  System.out.println("===currentTime:"+currentTime);
		  

		  // 특정 날짜 및 시간 갱체 생성
		  LocalDate yesterday = LocalDate.of(2016, 2, 9);	// 2016/02/09
		  LocalTime thatTime = LocalTime.of(18, 30, 34);		// 18:30:34
		  LocalDateTime theDay = LocalDateTime.of(yesterday, thatTime);		// 날짜와 시간으로 생성
		  LocalDateTime superDay = LocalDateTime.of(2016, 2, 5, 15, 0, 0);	// 2016/02/05 15:00:00
		  
		  System.out.println("===yesterday:"+yesterday);
		  System.out.println("===thatTime:"+thatTime);
		  System.out.println("===theDay:"+theDay);
		  System.out.println("===superDay:"+superDay);

		  // 날짜 및 시간을 파싱해서 생성
		  LocalDate thatDay = LocalDate.parse("2016-01-04");
		  LocalTime goHomeTime = LocalTime.parse("18:30:00");
		  LocalDateTime dayAndTime = LocalDateTime.parse("2016-01-04T18:30:00");	// 날짜와 시간을 T로 구분
		  // 기존 객체를 재활용하여 새로운 객체 생성
		  LocalDate localDate = today.withDayOfMonth(5);

		  System.out.println("===thatDay:"+thatDay);
		  System.out.println("===goHomeTime:"+goHomeTime);
		  System.out.println("===dayAndTime:"+dayAndTime);
		  System.out.println("===localDate:"+localDate);
		  
		  System.out.println("==================데이터 얻기=======================");
		  
		  LocalDateTime now2 = LocalDateTime.parse("2016-01-31T12:30:58");
		  
		  System.out.println("===now2:"+now2);
		  System.out.println("=================포맷=======================");
		  
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
		  LocalDateTime localDateTime = LocalDateTime.of(2016, 1, 1, 7, 30, 24);
		  System.out.println("===2016/01/01 07:30:24===>"+ formatter.format(localDateTime));

		  
		  System.out.println("=================연산=======================");
		  
		  LocalDateTime theDay2 = LocalDateTime.parse("2016-01-31T12:30:58");
		  System.out.println("58===>"+theDay2.getSecond());

		  // 10초 후 얻기
		  LocalDateTime after10Seconds = theDay.plusSeconds(10);
		  System.out.println("8===>"+after10Seconds.getSecond());

		  // 10일 후 얻기
		  LocalDateTime after10Days = theDay.plusDays(10);
		  System.out.println("2===>"+after10Days.getMonthValue());
		  System.out.println("10===>"+after10Days.getDayOfMonth());

		  // 10년 전 얻기
		  LocalDateTime before10Years = theDay.minusYears(10);
		  System.out.println("2006===>"+before10Years.getYear());

		  System.out.println("================특정 주기 지정=======================");
		// 5년, 2달, 10일
		  Period period = Period.of(5, 2, 10);
		  LocalDate theDate = LocalDate.of(2016, 10, 20);
		  LocalDate afterDate = theDate.plus(period);
		  System.out.println("2021===>"+afterDate.getYear());
		  System.out.println("12===>"+ afterDate.getMonthValue());
		  System.out.println("30===>"+afterDate.getDayOfMonth());
		  
		  
		  System.out.println("================날짜 간격, 기간=======================");
		  
		  LocalDateTime today5 = LocalDateTime.now();
		  LocalDateTime yesterday5 = today5.minusDays(1);
		  Duration durationOfDays = Duration.between(yesterday5, today5);
		  System.out.println("24===>"+ durationOfDays.toHours());
		  
		  System.out.println("================안타깝게도 아직 Java8에서는 새로운 날짜 및 시간 관련 API를 위해 JDBC의 날짜관련 클래스들을 직접 사용할 순 없다.=======================");
		  System.out.println("================대신 java.sql 패키지의 날짜 및 시간 관련 클래스들에 java.time패키지에 대응하는 메소드가 추가되었다.=======================");
		  
		  LocalDate today9 = LocalDate.now();
		  Date date = Date.valueOf(today9);
		  LocalDate localDate9 = date.toLocalDate();

		  LocalTime currentTime8 = LocalTime.now();
		  Time time = Time.valueOf(currentTime8);
		  LocalTime localTime = time.toLocalTime();

		  LocalDateTime now7 = LocalDateTime.now();
		  Timestamp timestamp = Timestamp.valueOf(now7);
		  LocalDateTime localDateTime7 = timestamp.toLocalDateTime();

		  Instant instant = Instant.now();
		  Timestamp timestampFromInstant = Timestamp.from(instant);
		  Instant intantFromTimestamp = timestampFromInstant.toInstant();
		  
		  System.out.println("================기존의 Date, Calendar 등을 대체하기 위해서 지금까지 많이 사용되던 Java .=======================");
		  System.out.println("================날짜 관련 라이브러리를 참고하여 보다 효율적이고 사용하기 편한 API 등장 ( java.time 패키지 @since 1.8 ).=======================");
		  LocalDateTime startDateTime = LocalDateTime.of(2020, 4, 6, 9, 0, 0);

	        System.out.println("시작일 : " + startDateTime);

	        LocalDateTime endDateTime = LocalDateTime.of(2024, 2, 5, 19, 0, 0);

	        System.out.println("종료 : " + endDateTime);

	 

	        if (startDateTime.isBefore(endDateTime))

	            System.out.println("\n이전 날짜인지 비교");

	        else if (startDateTime.isEqual(endDateTime))

	            System.out.println("동일 날짜인지 비교");

	        else if (startDateTime.isAfter(endDateTime))

	            System.out.println("이후 날짜인지 비교");

	 

	        System.out.println("\n[종료까지 남은 시간]");

	        System.out.println("남은 해 : " + startDateTime.until(endDateTime, ChronoUnit.YEARS));

	        System.out.println("남은 달 : " + startDateTime.until(endDateTime, ChronoUnit.MONTHS));

	        System.out.println("남은 일 : " + startDateTime.until(endDateTime, ChronoUnit.DAYS));

	        System.out.println("남은 시간 : " + startDateTime.until(endDateTime, ChronoUnit.HOURS));

	        System.out.println("남은 분 : " + startDateTime.until(endDateTime, ChronoUnit.MINUTES));

	        System.out.println("남은 초 : " + startDateTime.until(endDateTime, ChronoUnit.SECONDS));

	 

	        System.out.println("\n[종료까지 남은 기간]");

	        Period period2 = Period.between(startDateTime.toLocalDate(), endDateTime.toLocalDate());

	        System.out.print("남은 기간 : " + period2.getYears() + " 년 ");

	        System.out.println(period2.getMonths() + " 달 " + period2.getDays() + " 일");

	 

	        Duration duration = Duration.between(startDateTime.toLocalTime(), endDateTime.toLocalTime());

	        System.out.println("남은 초 : " + duration.getSeconds());
		  

	}

	
}

