import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicTacToeShould {

    @Test
    public void return_o_for_the_second_move(){
        Tictactoe tictactoe = new Tictactoe();
        tictactoe.alternateMove();
        assertEquals('o', tictactoe.alternateMove());
    }

    @Test
    public void return_x_for_the_third_move(){
        Tictactoe tictactoe = new Tictactoe();
        tictactoe.alternateMove();
        tictactoe.alternateMove();
        assertEquals('x', tictactoe.alternateMove());
    }

    @Test
    public void return_true_when_position_is_zero_zero(){
        Tictactoe tictactoe = new Tictactoe();
        int[] position = {0,0};
        assertEquals("true", tictactoe.makeMove(position));
    }

    @Test
    public void return_false_if_position_is_not_available(){
        Tictactoe tictactoe = new Tictactoe();
        int[] position ={0, 0};
        tictactoe.makeMove(position);
        assertEquals("false", tictactoe.makeMove(position));
    }

    @Test
    public void return_o_for_the_second_move_if_position_is_available(){
        Tictactoe tictactoe = new Tictactoe();
        int[] position ={0, 0};
        tictactoe.makeMove(position);
        position[0] = 0;
        position[1] = 1;
        tictactoe.makeMove(position);
        assertEquals('o', tictactoe.board[0][1]);
    }
    @Test
    public void check_if_board_is_not_full(){
        Tictactoe tictactoe = new Tictactoe();
        assertEquals(false,tictactoe.check_if_board_is_full());
    }

    @Test
    public void check_if_the_game_is_a_draw(){
        Tictactoe tictactoe = new Tictactoe();
        char[][] boardTest = {{'o', 'x','o'} , {'x', 'o','x'} , {' ', 'o','x'}};
        tictactoe.board = new char[3][3];
        tictactoe.board = boardTest;
        int[] position ={2, 0};
        assertEquals("DRAW",tictactoe.makeMove(position));
    }


}
