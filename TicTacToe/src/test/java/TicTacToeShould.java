import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeShould {

    @Test
    public void Test(){
        TicTacToe tictactoe = new TicTacToe();
        assertEquals("x", tictactoe.makeMove("x"));
    }

}
