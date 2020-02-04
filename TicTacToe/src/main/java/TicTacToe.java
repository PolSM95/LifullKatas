public class TicTacToe {
    String lastMove = "o";
    public String makeMove(String symbol) {
        if(symbol != "x"){
            throw new RuntimeException ("X always goes first, not: " + symbol);
        }
        if(lastMove == symbol){
            throw new RuntimeException ("Symbol has to be different, can't repeat symbol.");
        }
        lastMove = symbol;
        return "ok";
    }
}
