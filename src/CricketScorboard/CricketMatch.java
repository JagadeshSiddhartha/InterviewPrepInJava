package CricketScorboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Objects;

public class CricketMatch {
    private int score;
    private int overs;
    private int ball_in_over;
    private int wickets_fallen;
    private List<Player> players;
    private Player striker;
    private Player non_striker;
    private int total_fours;
    private int total_sixes;
    private int total_wides;
    private int total_noballs;
    private boolean match_complete;
    private final List<String> INVALID_BALLS = Arrays.asList("Wd", "Nb");


    public CricketMatch() {
        this.score = 0;
        this.overs = 0;
        this.ball_in_over = 0;
        this.wickets_fallen = 0;
        this.striker = new Player();
        this.non_striker = new Player();
        this.total_fours = 0;
        this.total_sixes = 0;
        this.total_wides = 0;
        this.total_noballs = 0;
        this.match_complete = false;
        this.players = new ArrayList<>();
        players.add(striker);
        players.add(non_striker);
    }
    public void processBall(String ball) {
       /* if(match_complete)
            throw Exception;
        */
        if(isValidBall(ball)) {
            if(isWicket(ball)) {
                striker.setPlayerOut();
                striker = new Player();
                players.add(striker);
                wickets_fallen += 1;
                if(wickets_fallen == 10) {
                    endMatch();
                }
            }
            else if(isBoundary(ball)) {
                increaseBoundaries(ball);
            } else {
                increaseScore(ball);
                if(playersRotated(ball)) {
                    rotatePlayers();
                }
            }
            //increasing balls and overs
            ball_in_over += 1;
            if(ball_in_over == 6) {
                overs += 1;
                if(overs == 2) {
                    endMatch();
                }
                ball_in_over = 0;
                rotatePlayers();
                displayScoreBoard();
            }
        } else {
            if(isWide(ball)) {
                score += 1;
                total_wides += 1;
            } if(isNoBall(ball)) {
                score += 1;
                total_noballs += 1;
            }
        }
    }

    private boolean isNoBall(String ball) {
        return ball.equals("Nb");
    }

    private boolean isWide(String ball) {
        return ball.equals("Wd");
    }

    private void endMatch() {
        match_complete = true;
    }

    private boolean isMatchActive() {
        return !match_complete;
    }


    private boolean isWicket(String ball) {
        return ball.equals("W");
    }

    private void displayScoreBoard() {
        System.out.println("Player \t Score \t 4s \t6s \tBalls");
        for(int player_num = 0; player_num < players.size(); player_num++ ) {
            Player player = players.get(player_num);
            System.out.print("P" + (player_num + 1));
            if(player.isOnField()) {
                System.out.print("*");
            }
            System.out.println("\t\t " + player.getScore() + "\t\t " + player.getFoursScored()
                                +"\t\t " + player.getSixesScored() + "\t\t " + player.getBallsPlayed());
        }
        System.out.println("Total: " + score + "/" + wickets_fallen);
        System.out.println("Overs: " + overs);
    }

    private void rotatePlayers() {
        Player temporaryPlayer = non_striker;
        non_striker = striker;
        striker = temporaryPlayer;
    }

    private boolean playersRotated(String ball) {
        if(ball.contains("lb")) {
            ball = ball.substring(0,ball.length() - 2);
        }
        return (Integer.parseInt(ball) % 2) == 1;
    }

    private void increaseScore(String ball) {
        if(ball.contains("lb")) {
            ball = ball.substring(0,ball.length() - 2);
        }
        striker.increaseScore(Integer.parseInt(ball));
    }

    private boolean isValidBall(String ball) {
        return !INVALID_BALLS.contains(ball);
    }
    private boolean isBoundary(String ball) {
        return ball.equals("4") || ball.equals("6");
    }

    private void increaseBoundaries(String ball) {
        if(Objects.equals(ball, "4")) {
            striker.increaseFours();
        } else if(Objects.equals(ball, "6")) {
            striker.increaseSixes();
        }
    }

    public int ballsInPresentOver() {
        return ball_in_over;
    }
}
