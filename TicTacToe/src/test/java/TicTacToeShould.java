import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicTacToeShould {


    @Test
    public void return_exception_when_symbol_is_different_from_x(){
        TicTacToe tictactoe = new TicTacToe();
        assertThrows(RuntimeException.class, () ->{
            tictactoe.makeMove("o");
        });
    }

    @Test
    public void return_exception_when_the_following_symbol_is_equal(){
        TicTacToe tictactoe = new TicTacToe();
        assertThrows(RuntimeException.class, () ->{
            tictactoe.makeMove("x");
            tictactoe.makeMove("x");
        });
    }

}
