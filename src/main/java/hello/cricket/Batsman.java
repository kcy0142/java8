//http://www.kswaughs.com/2016/12/spring-boot-websocket-server-push.html
package hello.cricket;
 
public class Batsman {
    
    private String name;
    
    private int runs;
    
    private int balls;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }
    
}