
package hello.quartz.loonyhyun;
 


import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;

public class FirstJobExecutor {
	public static void main(String[] args) throws Exception {

		
		JobKey firstJobKey = new JobKey("firstJobKey", "Group");
	    JobDetail job = JobBuilder.newJob(FirstJob.class).withIdentity(firstJobKey)
	            .build();

         

		// Trigger the job to run on the next round minute
		Trigger trigger = TriggerBuilder
			.newTrigger()
			.withIdentity("simpleTriggerName", "group1")
			.withSchedule(
				SimpleScheduleBuilder.simpleSchedule()
					.withIntervalInSeconds(5).repeatForever())
			.build();

			
		// schedule it
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.getListenerManager().addJobListener(new FirstListener(), KeyMatcher.keyEquals(firstJobKey));
		scheduler.start();
		
		
		
		scheduler.scheduleJob(job, trigger);

	}
}