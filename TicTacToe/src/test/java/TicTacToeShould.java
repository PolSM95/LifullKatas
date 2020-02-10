import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicTacToeShould {

    @Test
    public void return_o_for_the_second_move(){

        Tictactoe tictactoe = new Tictactoe();
        tictactoe.makeMove();
        assertEquals("o", tictactoe.makeMove());
    }

    @Test
    public void return_x_for_the_third_move(){
        Tictactoe tictactoe = new Tictactoe();
        tictactoe.makeMove();
        tictactoe.makeMove();
        assertEquals("x", tictactoe.makeMove());

    }



}
