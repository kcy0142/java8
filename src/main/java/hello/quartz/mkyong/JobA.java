
package hello.quartz.mkyong;
 
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import hello.quartz.SimpleService;

public class JobA implements Job {

	@Override
	public void execute(JobExecutionContext context)throws JobExecutionException {
		System.out.println("Job A is runing");
	}

}