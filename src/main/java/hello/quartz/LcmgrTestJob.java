
package hello.quartz;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import hello.util.DateUtil;

public class LcmgrTestJob implements Job {
	 
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        /*
         * Job Interface를 implements하여
         * execute 메소드에 로직을 넣는다.
         * Quartz Scheduler는 기능을 수행하는 단위인 Job과 스케쥴에 대한 정보를 가진 Trigger를 스케쥴러에 걸어 실행하는 구조이다. 
         * 먼저 스케쥴에 따라 동작할 Job클래스를 작성한다.
         * */
        System.out.println("--------------------------job수행---------------------------");
        System.out.println(DateUtil.getCurrentTime());
    }
 
}
