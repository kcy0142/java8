
package hello.quartz.tutorial;
 
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;

/**
 * This class is used for executing quartz job 
 * using SimpleTrigger(Quartz 2.1.5).
 * @author javawithease
 */
public class SimpleTriggerTest {
	public static void main(String args[]){
    	try{
    		//Set job key.
    		JobKey jobKey = new JobKey("helloJob", "group1");
    		//Set job details.
    		JobDetail job = JobBuilder.newJob(HelloJob.class)
    				.withIdentity(jobKey).build();
 
        	//Set the scheduler timings.
    		Trigger trigger = TriggerBuilder.newTrigger()
    		  .withIdentity("simpleTrigger", "group1")
    		  .withSchedule(SimpleScheduleBuilder.simpleSchedule()
    		  .withIntervalInSeconds(10).repeatForever()).build();
 
        	//Execute the job.
    		Scheduler scheduler = 
    			new StdSchedulerFactory().getScheduler();
    		//Attach listener to jobKey, 
    		//use GroupMatcher.jobGroupEquals("groupName")
    		//to attach with group. 
    		scheduler.getListenerManager().addJobListener(
    	    		new HelloJobListener(), 
    	    		KeyMatcher.keyEquals(jobKey));
        	scheduler.start();
        	scheduler.scheduleJob(job, trigger);
    	}catch(Exception e){
    		e.printStackTrace();
    	}    	
	}
}