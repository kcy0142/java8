
package hello.quartz.tutorial;
 
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
 
/**
 * This class defines a quartz job.
 * @author javawithease
 */
public class HelloJob implements Job{
	public void execute(JobExecutionContext context)
			throws JobExecutionException {	 
		System.out.println("Hello World.");		 
	}
}