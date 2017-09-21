
package hello.quartz.mkyong;
 
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;


public class CronTriggerExample {
	public static void main( String[] args ) throws Exception
    {

		JobKey jobKeyA = new JobKey("jobA", "group1");
    	JobDetail jobA = JobBuilder.newJob(JobA.class)
		.withIdentity(jobKeyA).build();

    	JobKey jobKeyB = new JobKey("jobB", "group1");
    	JobDetail jobB = JobBuilder.newJob(JobB.class)
		.withIdentity(jobKeyB).build();
    	
    	JobKey jobKeyC = new JobKey("jobC", "group1");
    	JobDetail jobC = JobBuilder.newJob(JobC.class)
		.withIdentity(jobKeyC).build();
    	
    	JobKey jobKeyD = new JobKey("jobD", "group1");
    	JobDetail jobD = JobBuilder.newJob(JobD.class)
		.withIdentity(jobKeyD).build();

    	JobKey jobKey = new JobKey("dummyJobName", "group1");


    	Trigger trigger1 = TriggerBuilder
		.newTrigger()
		.withIdentity("dummyTriggerName1", "group1")
		.withSchedule(
			CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
		.build();

    	Trigger trigger2 = TriggerBuilder
		.newTrigger()
		.withIdentity("dummyTriggerName2", "group1")
		.withSchedule(
			CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
		.build();

    	Trigger trigger3 = TriggerBuilder
		.newTrigger()
		.withIdentity("dummyTriggerName3", "group1")
		.withSchedule(
			CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
		.build();
    	
    	Trigger trigger4 = TriggerBuilder
    			.newTrigger()
    			.withIdentity("dummyTriggerName4", "group1")
    			.withSchedule(
    				CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
    			.build();

    	Scheduler scheduler = new StdSchedulerFactory().getScheduler();

    	
    	//Listener attached to jobKey
    	scheduler.getListenerManager().addJobListener(
    		new HelloJobListener(), KeyMatcher.keyEquals(jobKeyC)
    	);
    	
    	scheduler.start();
    	scheduler.scheduleJob(jobA, trigger1);
    	scheduler.scheduleJob(jobB, trigger2);
    	scheduler.scheduleJob(jobC, trigger3);
    	//scheduler.scheduleJob(jobD, trigger4);

    }
}
