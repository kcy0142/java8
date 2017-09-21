
package hello.cricket;
 

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import message.HelloMessage2;


@Configuration
@EnableScheduling
public class ScoreScheduler {
        
    @Autowired
    private SimpMessagingTemplate template;
    
    @Autowired
    LiveScoreService service;

    //5 second
    @Scheduled(fixedRate = 5000)
    public void publishUpdates(){
       
    	HelloMessage2 message= new HelloMessage2();
    	message.setName("admin");
    	message.setContents(new Date().toString() + " : 이것은 서버 메시지 입니다.");
    	message.setSendDate(new Date());
        //template.convertAndSend("/topic/notice_test",message);
        
        template.convertAndSend("/topic/myscores", service.getScore());

       
    }
 
}