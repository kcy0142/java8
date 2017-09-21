
package hello.quartz.loonyhyun;
 
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
 
public class FirstJob implements Job {
 
    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
 
        long starttimes = System.currentTimeMillis();
        System.out.println("Job Start.");
        
        
        System.out.println("Job End.");
        System.out.println("DuringTime : " + (System.currentTimeMillis() - starttimes));
 
    }
    
}
