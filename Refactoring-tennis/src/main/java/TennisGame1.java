
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
        int tempScore;
        String score = "";
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = scorePlayer1;
            else { score+="-"; tempScore = scorePlayer2;}
            switch(tempScore)
            {
                case 0:
                    score+="Love";
                    break;
                case 1:
                    score+="Fifteen";
                    break;
                case 2:
                    score+="Thirty";
                    break;
                case 3:
                    score+="Forty";
                    break;
            }
        }
        return score;
    }

    private String checkScoreWhenIsMoreThanFortyPoints() {
        String score;
        int minusResult = scorePlayer1 - scorePlayer2;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private String checkDrawType() {
        String score;
        switch (scorePlayer1)
        {
            case 0:
                    score = "Love-All";
                break;
            case 1:
                    score = "Fifteen-All";
                break;
            case 2:
                    score = "Thirty-All";
                break;
            default:
                    score = "Deuce";
                break;

        }
        return score;
    }
}
