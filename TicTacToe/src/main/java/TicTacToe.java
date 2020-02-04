public class TicTacToe {
    String lastMove = "o";
    Boolean firstMove = true;
    public String makeMove(String symbol) {
        if(lastMove == symbol){
            throw new RuntimeException ("Symbol has to be different, can't repeat symbol.");
        }
        if(symbol != "x" && firstMove){
            throw new RuntimeException ("X always goes first, not: " + symbol);
        }
        firstMove = false;
        lastMove = symbol;
        return "ok";
    }
}
