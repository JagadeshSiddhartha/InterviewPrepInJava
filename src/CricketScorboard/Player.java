package CricketScorboard;

public class Player {
    private int  score;
    private int fours_scored;
    private int sixes_scored;
    private int balls_played;
    private boolean is_on_field;
//    private String name;

    public Player() {
//        this.name = name;
        this.score = 0;
        this.fours_scored = 0;
        this.sixes_scored = 0;
        this.balls_played = 0;
        this.is_on_field = true;
    }

    public int getScore() {
        return score;
    }

    public int getFoursScored() {
        return fours_scored;
    }

    public int getSixesScored() {
        return sixes_scored;
    }

    public int getBallsPlayed() {
        return balls_played;
    }

    public void increaseScore(int run) {
        if(isBoundary(run)) {
         increaseBoundaries(run);
        }
        this.score += run;
        this.balls_played += 1;
    }

    private boolean isBoundary(int run) {
        if(run == 4 || run == 6)
            return true;
        return false;
    }

    private void increaseBoundaries(int run) {
        if(run == 4) {
            this.fours_scored += 1;
        } else if(run == 6) {
            this.sixes_scored += 1;
        }
    }

    public void increaseSixes() {
        this.sixes_scored += 1;
        this.score += 6;
    }

    public void increaseFours() {
        this.fours_scored += 1;
        this.score += 4;
    }

    public void setPlayerOut() {
        balls_played += 1;
        is_on_field = false;
    }

    public boolean isOnField() {
        return is_on_field;
    }
}
