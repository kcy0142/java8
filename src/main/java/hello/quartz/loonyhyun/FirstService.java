
package hello.quartz.loonyhyun;
 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FirstService {
    private static final Logger LOG = LoggerFactory.getLogger(FirstService.class);

    public String processData() {
        LOG.info("Hello World!");
        System.out.println("Hello World System !");
        return "test";
    }
}