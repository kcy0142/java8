
package hello.quartz.loonyhyun;
 
import java.text.SimpleDateFormat;
import java.util.Date;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

 
public class FirstListener implements JobListener {
	
	@Autowired
	private FirstService firstService;
	
    public String getName(){
        return "FirstListener";
    }
 
    public void jobExecutionVetoed(JobExecutionContext arg0) {
        System.out.println("Vetoed. " + nowDateStr());
    }
 
    public void jobToBeExecuted(JobExecutionContext arg0) {
        System.out.println("To Be Executed. " + nowDateStr());
    }
 
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
    	/*try {
			ApplicationContext applicationContext = (ApplicationContext) context.getScheduler().getContext().get("applicationContext");
			firstService = applicationContext.getBean(FirstService.class);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
    	
    	
    	
    	String test=firstService.processData();
    	
    	System.out.println("test data: " + test);*/
    	
    	//FirstService firstService1=(FirstService) SpringContextUtil.getBean("FirstService");
    	 
    	//String test=firstService1.processData();
    	
    	//System.out.println("test data: " + test);
    	
        System.out.println("Was Executed. " + nowDateStr());
    }
    
    public String nowDateStr(){
        SimpleDateFormat SdfTimer = new SimpleDateFormat("yyyyMMddHHmmss");
      
        FirstService firstService1=(FirstService) SpringContextUtil.getBean("FirstService");
   	 
    	String test=firstService1.processData();
    	
    	System.out.println("test data: " + test);
        return SdfTimer.format(new Date());
    }
 
}
