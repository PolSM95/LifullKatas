
public class TennisGame3 implements TennisGame {
    
    private int player2Score;
    private int player1Score;
    private String player1ScoreMessage;
    private String player2ScoreMessage;

    public TennisGame3(String player1ScoreMessage, String player2ScoreMessage) {
        this.player1ScoreMessage = player1ScoreMessage;
        this.player2ScoreMessage = player2ScoreMessage;
    }

    public enum Messages{
        LOVE ("Love"),
        FIFTEEN ("Fifteen"),
        THIRTY ("Thirty"),
        FORTY ("Forty"),
        ALL ("All"),
        WIN ("Win for"),
        DEUCE ("Deuce"),
        ADVANTAGE ("Advantage"),
        PLAYER1 (" Player 1"),
        PLAYER2 (" Player 2"),
        DASH ("-");

        String message;
        private Messages(String message){
            this.message = message;
        }
    }


    public String getScore() {
        String resultMessage;
        Messages[] enumList = new Messages[]{Messages.LOVE, Messages.FIFTEEN, Messages.THIRTY, Messages.FORTY};
        if (checkWhenNotDeuceAdvantageOrWin()) {
            String[] scoreList = new String[]{enumList[0].message, enumList[1].message, enumList[2].message, enumList[3].message};
            return returnMessageWhileNotDeuceAdvantageOrWin(scoreList);
        }
        if (player1Score == player2Score)
            return "Deuce";
        resultMessage = player1ScoreMessage;
        if (player1Score < player2Score) resultMessage = player2ScoreMessage;
        if(checkIfAdvantageOrWin()) return "Advantage " + resultMessage;
        return "Win for " + resultMessage;
    }

    private boolean checkIfAdvantageOrWin() {
        return (player1Score - player2Score)*(player1Score - player2Score) == 1;
    }

    private boolean checkWhenNotDeuceAdvantageOrWin() {
        return player1Score < 4 && player2Score < 4 && !(player1Score + player2Score == 6);
    }

    private String returnMessageWhileNotDeuceAdvantageOrWin(String[] scoreList) {
        return (player1Score == player2Score) ? scoreList[player1Score] + "-All" : scoreList[player1Score] + "-" + scoreList[player2Score];
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.player1Score += 1;
        else
            this.player2Score += 1;
        
    }

}
