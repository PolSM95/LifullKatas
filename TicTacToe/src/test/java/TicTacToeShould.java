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

    @Test
    public void return_true_when_position_is_zero_zero(){
        Tictactoe tictactoe = new Tictactoe();
        int[] position = {0,0};
        assertEquals(true, tictactoe.checkPosition(position));
    }

    @Test
    public void return_false_if_position_is_not_available(){
        Tictactoe tictactoe = new Tictactoe();
        int[] position ={0, 0};
        tictactoe.checkPosition(position);
        assertEquals(false, tictactoe.checkPosition(position));
    }

    @Test
    public void return_o_for_the_second_move_if_position_is_available(){
        Tictactoe tictactoe = new Tictactoe();
        int[] position ={0, 0};
        tictactoe.checkPosition(position);
        position[0] = 0;
        position[1] = 1;
        tictactoe.checkPosition(position);
        assertEquals('o', tictactoe.board[0][1]);
    }



}
