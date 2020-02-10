public class Tictactoe {

    String lastMove = "o";

    public String makeMove() {
        if (lastMove.equals("o")){
            lastMove = "x";
        } else {
            lastMove = "o";
        }
        return lastMove;
    }
}
