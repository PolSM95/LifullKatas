public class Tictactoe {

    String lastMove = "o";

    public String makeMove() {
        if (lastMove.equals("o")){
            lastMove = "x";
            return "x";
        }
        lastMove = "o";
        return "o";
    }
}
