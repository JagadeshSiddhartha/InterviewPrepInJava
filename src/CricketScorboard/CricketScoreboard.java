package CricketScorboard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CricketScoreboard {
    public static void main(String[] args) throws IOException {
        CricketMatch match = new CricketMatch();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while(match.ballsInPresentOver() < 6) {
            String ball = bf.readLine().toString();
            if(ball.startsWith("Over")) {
                continue;
            }
            match.processBall(ball);
        }
    }
}
