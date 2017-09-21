
package hello.quartz;
 
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;



public class SimpleJob2  implements Job{

    @Autowired
    private SimpleService service;

   
    public void execute() throws Exception {
    	System.out.println("awwwwwwwwwwwwwwwww");
        service.processData();
    }


	/* (non-Javadoc)
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		/**
		 * A Table에서 데이터를 획득하기 위한 Select Query를 수행한다.
		 *
		 * @param stmt Statement 객체.
		 * @param query String SQL Query.
		 * @return ResultSet Query를 수행한 결과.
		 * @exception SQLException SQL 처리 에러발생.
		 */
		
		
		
	}
}