
package hello.quartz.mkyong;
 


import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.JobListener;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import hello.quartz.SimpleService;


public class QuartzJobListener implements JobListener {

	private static final Logger logger = LoggerFactory.getLogger(QuartzJobListener.class);

	public static final String LISTENER_NAME = "dummyJobListenerName";
	
	@Autowired
	 private SimpleService service;

	

	@Override
	public String getName() {
		return LISTENER_NAME; //must return a name
	}




	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
		// Do nothing

	}

	@Override
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {

		try {
			ApplicationContext applicationContext = (ApplicationContext) context.getScheduler().getContext().get("applicationContext");
			service = applicationContext.getBean(SimpleService.class);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.processData();
	}
	

	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		// Do nothing
		
	}
}
