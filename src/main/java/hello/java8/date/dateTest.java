
package hello.java8.date;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class dateTest {

	
	//http://kwseo.github.io/java/2016/02/10/java8-about-date-2.html
	public static void main(String[] args) {
		
		    System.out.println("==================localDateTest=======================");
			System.out.println();
	        LocalDate today = LocalDate.now();
	        System.out.println(today);//2017-09-18

	        int year = today.getYear();
	        int month = today.getMonthValue();
	        int day = today.getDayOfMonth();
	        System.out.println(year + "." + month + "." + day); //2017.9.18

	        LocalDate christMasDate = LocalDate.of(2015, 12, 25);
	        System.out.println(christMasDate); //2015-12-25

	        LocalDate anotherDate = LocalDate.of(2015, 12, 25);
	        if(christMasDate.equals(anotherDate)) {
	            System.out.printf("same day : %s\n", anotherDate); //same day : 2015-12-25
	        }

	        YearMonth yearMonthNow = YearMonth.now();
	        System.out.println("yearMonth : " + yearMonthNow); //yearMonth : 2017-09

	        MonthDay birthday = MonthDay.of(christMasDate.getMonth(), christMasDate.getDayOfMonth());
	        System.out.println("monthday : " + birthday);  //monthday : --12-25
	        MonthDay MonthDayNow = MonthDay.from(today);
	        if (MonthDayNow.equals(birthday)) {
	            System.out.println("Today is birthday.");
	        } else {
	            System.out.println("Today is not birthday");  //Today is not birthday
	        }

	        LocalDate christMasEveDate = LocalDate.of(2015, 12, 24);
	        System.out.println(christMasEveDate.isBefore(christMasDate)); // true


	        System.out.println("1 week after : " + today.plus(1, ChronoUnit.WEEKS));  //1 week after : 2017-09-25
	        System.out.println("1 day after : " + today.plus(1, ChronoUnit.DAYS));//1 day after : 2017-09-19
	        System.out.println("1 century after : " + today.plus(1, ChronoUnit.CENTURIES));//1 century after : 2117-09-18
	        System.out.println("1 year after : " + today.plus(1, ChronoUnit.YEARS));//1 year after : 2018-09-18

	        System.out.println("leap year : " + today.isLeapYear());// leap year : false
	        
	      
	        
	        
	        
	        System.out.println("====================localTimeTest=====================");
	        
	        System.out.println();
	        LocalTime time = LocalTime.now();
	        System.out.println("time : " + time);//time : 18:16:03.848
	        System.out.println("2 hours after : " + time.plusHours(2));//2 hours after : 20:16:03.848
	        System.out.println("3 hours before : " + time.minusHours(2));//3 hours before : 16:16:03.848
	        
	        System.out.println("=====================clockTest====================");
	        
	        System.out.println();
	        Clock clock = Clock.systemUTC();
	        System.out.println("Clock : " + clock);//Clock : SystemClock[Z]
	        System.out.println("Clock (zone) : " + clock.getZone());//Clock (zone) : Z

	        Clock laClock= Clock.system(ZoneId.of("America/Los_Angeles"));
	        System.out.println("LA Clock : " + laClock);//LA Clock : SystemClock[America/Los_Angeles]
	        System.out.println("===========periodTest==============================");
	        
	        System.out.println();
	        LocalDate startLocatDate = LocalDate.of(2015, Month.MARCH, 1);
	        LocalDate endLocatDate = LocalDate.of(2015, Month.OCTOBER, 1);

	        System.out.println("====startLocatDate:"+startLocatDate);//====startLocatDate:2015-03-01
	        System.out.println("====endLocatDate:"+endLocatDate);//====endLocatDate:2015-10-01
	        Period period = Period.between(startLocatDate, endLocatDate);
	        System.out.println(period.getMonths()); // 7달  

	        LocalDate next = endLocatDate.plus(period); //2016-05-01
	        System.out.println(next); // 7달 뒤
	        System.out.println("===============timeStampTest==========================");
	        System.out.println();
	        Instant timestamp = Instant.now();
	        System.out.println(timestamp);//2017-09-18T09:16:03.852Z
	        
	        System.out.println("===============formatterTest==========================");
	        
	       System.out.println();
	       
	        String sentDate="20170920";
	        int yyyy = Integer.parseInt(sentDate.substring(0, 4)); 
			int mm = Integer.parseInt(sentDate.substring(4, 6)); 
			int dd = Integer.parseInt(sentDate.substring(6)); 


			LocalDate date = LocalDate.of(yyyy, mm, dd);
			System.out.println("==========date:"+date); //==========date:2017-09-20
			System.out.println("==========date LocalTime.MIN :"+LocalDateTime.of(date, LocalTime.MIN)); //==========date LocalTime.MIN :2017-09-20T00:00
			System.out.println("==========date LocalTime.MIDNIGHT:"+LocalDateTime.of(date, LocalTime.MIDNIGHT)); //	==========date LocalTime.MIDNIGHT:2017-09-20T00:00
			System.out.println("==========date  LocalTime.MAX:"+LocalDateTime.of(date, LocalTime.MAX)); //==========date  LocalTime.MAX:2017-09-20T23:59:59.999999999
			System.out.println("==========date  LocalTime.NOON:"+LocalDateTime.of(date, LocalTime.NOON));//==========date  LocalTime.NOON:2017-09-20T12:00
			
		
			

	}

	
}

