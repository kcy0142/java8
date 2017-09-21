
package hello.cricket;
 

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;


@Component
public class LiveScoreService {
    
    private List<Batsman> scoresList = initialScores();
    
    public List<Batsman> getScore() {

        Random rand = new Random();

        int randomNum = rand.nextInt((2 - 1) + 1);
        System.out.println("====randomNum:"+randomNum);
        Batsman batsman = scoresList.get(randomNum);

        batsman.setBalls(batsman.getBalls() + 1);
        batsman.setRuns(batsman.getRuns() + 1);

        return scoresList;
    }

    private List<Batsman> initialScores() {

        Batsman sachin = new Batsman();

        sachin.setName("Sachin Tendulkar");
        sachin.setRuns(24);
        sachin.setBalls(26);

        Batsman ganguly = new Batsman();
        ganguly.setName("Sourav Ganguly");
        ganguly.setRuns(28);
        ganguly.setBalls(30);

        List<Batsman> scoresList = new ArrayList<Batsman>();

        scoresList.add(sachin);
        scoresList.add(ganguly);

        return scoresList;
    }

}