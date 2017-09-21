package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hello.quartz.LcmgrTestScheduler;

@SpringBootApplication
public class Application {

	@Autowired
    private LcmgrTestScheduler scheduler;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
