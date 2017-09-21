
package hello.quartz;
 
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;



public class SimpleJob implements Job{

    @Autowired
    private SimpleService service;
    
    @Autowired
	private ApplicationContext context;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    	System.out.println("ttttttttttttttttttttt");
    	if ( service == null ) {
    		System.out.println("fffffffffffffff");
    		//service = (SimpleService) context.getBean("SimpleService");
    		service =context.getBean(SimpleService.class);
    	}
        service.processData();
    }
}