package hello;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketSession;

import hello.cricket.Batsman;
import hello.cricket.LiveScoreService;
import hello.cricket.TSchedule;
import message.HelloMessage2;

@Controller
//메시지를 수신해서 처리하는 클래스 정의.

public class GreetingController {

	@Autowired
    private LiveScoreService service;

	
	@Autowired
	TSchedule tSchedule;

	
	//- @MessageMapping : 메시지가 목적지로 전송하는 경우 해당 메소드를 실행 해줍니다.
	//- @SendTo : 메소드에서반환된 객체를 모든 가입자(유저)에게 방송 합니다.
    @MessageMapping("/hello") // 요청 토픽이 "/hello"일 때 처리할 함수. 
    @SendTo("/topic/greetings")  // 응답을 보낼 토픽 주소
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        // Greeting 클래스로 응답을 전달. json 형태로 전달됨.
        System.out.println("================Greeting greeting:");
        return new Greeting("Hello, " + message.getName() + "!");
    }
    
	//- @MessageMapping : 메시지가 목적지로 전송하는 경우 해당 메소드를 실행 해줍니다.
	//- @SendTo : 메소드에서반환된 객체를 모든 가입자(유저)에게 방송 합니다.
    @MessageMapping("/hello2") // 요청 토픽이 "/hello"일 때 처리할 함수. 
    @SendTo("/topic/hello2")  // 응답을 보낼 토픽 주소
    public HelloMessage2 hello(HelloMessage2 message) throws Exception {
        Thread.sleep(1000); // simulated delay
        System.out.println("================hello:");
        
        //배치 실행
        tSchedule.execute();
        
        // Greeting 클래스로 응답을 전달. json 형태로 전달됨.
        return message;
    }
    
    @MessageMapping("bye") // 요청 토픽이 "/hello"일 때 처리할 함수. 
    @SendTo("/topic/bye")  // 응답을 보낼 토픽 주소
    public HelloMessage2 bye(HelloMessage2 message) throws Exception {
        Thread.sleep(1000); // simulated delay
        System.out.println("================bye:"+message.getName());
      
        
        return message;
    }
    
    @MessageMapping("/detail") // 요청 토픽이 "/hello"일 때 처리할 함수. 
    @SendTo("/topic/detail")  // 응답을 보낼 토픽 주소
    public HelloMessage2 detail(HelloMessage2 message) throws Exception {
        Thread.sleep(1000); // simulated delay
        System.out.println("================detail:");
        Random rand = new Random();
        int randomNum = rand.nextInt(4);
        message.setSendDate(new Date());
        message.setImageNo(randomNum);
        return message;
    }

    @MessageMapping("/score")
    @SendTo("/topic/myscores")
    public List<Batsman> getScores() {
        
        List<Batsman> scoresList = service.getScore();
        
        return scoresList;
    }

}
