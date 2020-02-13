public class TennisGame1 implements TennisGame {
    
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;

    public TennisGame1() {
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            scorePlayer1 += 1;
        else
            scorePlayer2 += 1;
    }

    public String getScore() {
        if (isSameScore()) {
            return checkDrawType();
        }
        if (isAboveForty()) {
            return checkScoreWhenIsMoreThanFortyPoints();
        }
        return checkScoreBelowFortyIncluded();
    }

    private boolean isAboveForty() {
        return scorePlayer1 >= 4 || scorePlayer2 >= 4;
    }

    private boolean isSameScore() {
        return scorePlayer1 == scorePlayer2;
    }

    private String checkScoreBelowFortyIncluded() {
        String[] scoreList = {"Love", "Fifteen","Thirty", "Forty"};
        return scoreList[scorePlayer1]+"-"+scoreList[scorePlayer2];
    }

    private String checkScoreWhenIsMoreThanFortyPoints() {
        int minusResult = scorePlayer1 - scorePlayer2;
        if (minusResult==1) return "Advantage player1";
        if (minusResult ==-1) return "Advantage player2";
        if (minusResult>=2) return "Win for player1";
        return "Win for player2";
    }

    private String checkDrawType() {
        if(scorePlayer1>2) return "Deuce";
        String[] scoreList = {"Love-All", "Fifteen-All","Thirty-All"};
        return scoreList[scorePlayer1];
    }
}
