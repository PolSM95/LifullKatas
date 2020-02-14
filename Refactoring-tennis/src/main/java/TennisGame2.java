
public class TennisGame2 implements TennisGame {
    public int player1Score = 0;
    public int player2Score = 0;

    public String player1ScoreMessage = "";
    public String player2ScoreMessage = "";

    public TennisGame2() {
    }

    public String getScore() {
        String score = "";
        if (isTieAndBelowForty()) {
            score = checkTieAndBelowForty();
        }
        if (player1Score == player2Score && player1Score >= 3)
            score = "Deuce";

        score = checkWhenOnlyOnePlayerHasNotScored(score);
        score = checkWhenAPlayerIsLeadingAndBelowFourty(score);

        if (checkAdvantagePlayerOne()) {
            score = "Advantage player1";
        }

        if (checkAdvantagePlayerTwo()) {
            score = "Advantage player2";
        }

        if (checkIfPlayerOneWins()) {
            score = "Win for player1";
        }
        if (checkIfPlayerTwoWins()) {
            score = "Win for player2";
        }
        return score;
    }

    private String checkWhenAPlayerIsLeadingAndBelowFourty(String score) {
        if (player1Score > player2Score && player1Score < 4) {
            score = checkScoreWhenPlayerOneIsLeadingAndBelowFourty();
        }
        if (player2Score > player1Score && player2Score < 4) {
            score = checkScoreWhenPlayerTwoIsLeadingAndBelowFourty();
        }
        return score;
    }

    private String checkWhenOnlyOnePlayerHasNotScored(String score) {
        if (player1Score > 0 && player2Score ==0) {
            score = checkWhenOnlyPlayerTwoHasNotScored(score);
        }

        if (player2Score > 0 && player1Score == 0) {
            score = checkScoreForPlayerTwoWhenPlayerOneHasNotScored();
        }
        return score;
    }

    private boolean checkAdvantagePlayerTwo() {
        return player2Score > player1Score && player1Score >= 3;
    }

    private boolean checkAdvantagePlayerOne() {
        return player1Score > player2Score && player2Score >= 3;
    }

    private boolean checkIfPlayerOneWins() {
        return player1Score >= 4 && player2Score >= 0 && (player1Score - player2Score) >= 2;
    }

    private boolean checkIfPlayerTwoWins() {
        return player2Score >= 4 && player1Score >= 0 && (player2Score - player1Score) >= 2;
    }

    private String checkScoreWhenPlayerTwoIsLeadingAndBelowFourty() {
        String score;
        if (player2Score == 2)
            player2ScoreMessage = "Thirty";
        if (player2Score == 3)
            player2ScoreMessage = "Forty";
        if (player1Score == 1)
            player1ScoreMessage = "Fifteen";
        if (player1Score == 2)
            player1ScoreMessage = "Thirty";
        score = player1ScoreMessage + "-" + player2ScoreMessage;
        return score;
    }

    private String checkScoreWhenPlayerOneIsLeadingAndBelowFourty() {
        String score;
        if (player1Score == 2)
            player1ScoreMessage = "Thirty";
        if (player1Score == 3)
            player1ScoreMessage = "Forty";
        if (player2Score == 1)
            player2ScoreMessage = "Fifteen";
        if (player2Score == 2)
            player2ScoreMessage = "Thirty";
        score = player1ScoreMessage + "-" + player2ScoreMessage;
        return score;
    }

    private String checkScoreForPlayerTwoWhenPlayerOneHasNotScored() {
        String score;
        if (player2Score == 1)
            player2ScoreMessage = "Fifteen";
        if (player2Score == 2)
            player2ScoreMessage = "Thirty";
        if (player2Score == 3)
            player2ScoreMessage = "Forty";

        player1ScoreMessage = "Love";
        score = player1ScoreMessage + "-" + player2ScoreMessage;
        return score;
    }

    private String checkWhenOnlyPlayerTwoHasNotScored(String score) {


        if (player1Score == 1)
            player1ScoreMessage = "Fifteen";
        if (player1Score == 2)
            player1ScoreMessage = "Thirty";
        if (player1Score == 3)
            player1ScoreMessage = "Forty";

        player2ScoreMessage = "Love";
        score = player1ScoreMessage + "-" + player2ScoreMessage;

        return score;
    }

    private String checkTieAndBelowForty() {
        String score = "";
        if (player1Score ==0)
            score = "Love";
        if (player1Score ==1)
            score = "Fifteen";
        if (player1Score ==2)
            score = "Thirty";
        score += "-All";
        return score;
    }

    private boolean isTieAndBelowForty() {
        return player1Score == player2Score && player1Score < 4;
    }

    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        player1Score++;
    }
    
    public void P2Score(){
        player2Score++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}