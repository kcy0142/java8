
package hello.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * <PRE>
 * test
 * </PRE>
 * 
 * @author 김청욱
 * @version v1.0 2017. 9. 7.
 */
public class test {

	

	public static void main(String[] args) {
		Calendar start = new GregorianCalendar();
		//start.add(Calendar.DATE, -1);
		start.set(Calendar.HOUR_OF_DAY, 0); 
		start.set(Calendar.MINUTE, 0);
		start.set(Calendar.SECOND, 0);
	    
	    System.out.println("start:"+start.getTime());
	    
	    Calendar end = new GregorianCalendar();
	   // end.add(Calendar.DATE, -1);
	    end.set(Calendar.HOUR_OF_DAY, 11); 
	    end.set(Calendar.MINUTE, 59);
	    end.set(Calendar.SECOND, 59);
	    
	    System.out.println("end:"+end.getTime());

	}

	
}

