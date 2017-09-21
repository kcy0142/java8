/* ------------------------------------------------------------------------------
 * Project       : NextEP Project VPA System
 * Source        : TSchedule.java
 * Author        : 김청욱
* Copyright 2017 LG CNS All rights reserved
*------------------------------------------------------------------------------ */

/**
 * <PRE>
 * test
 * </PRE>
 * 
 * @author 김청욱
 * @version v1.0 2017. 8. 31.
 */
package hello.cricket;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TSchedule
{
	//@Scheduled(cron="0/10 * * * * ?")
	@Scheduled(cron = "*/5 * * * * *") // 5초마다 수행하도록 설정
	public void execute()
	{
		//System.out.println("10초마다 출력");
		System.out.println("5초마다 출력");
	}
}
