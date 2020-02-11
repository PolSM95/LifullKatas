import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TicTacToeCalisthenicsShould {

    @Test
    public void starting_the_game_with_player_x_and_returning_next_player_turn_O(){
        TicTacToe tictactoe = new TicTacToe();
        assertEquals(OutputMessage.turnO,tictactoe.putPosition(Position.POSITION00));
        
    }

    @Test
    public void making_two_moves_and_returning_next_player_turn_X(){
        TicTacToe tictactoe = new TicTacToe();
        tictactoe.putPosition(Position.POSITION00);
        assertEquals(OutputMessage.turnX, tictactoe.putPosition(Position.POSITION01));
    }
    @Test
    public void check_if_position_is_taken(){
        TicTacToe tictactoe = new TicTacToe();
        tictactoe.putPosition(Position.POSITION00);
        assertEquals(OutputMessage.taken,tictactoe.putPosition(Position.POSITION00));
    }

    @Test
    public void check_if_board_is_full(){
        TicTacToe tictactoe = new TicTacToe();
        tictactoe.putPosition(Position.POSITION01);
        tictactoe.putPosition(Position.POSITION02);
        tictactoe.putPosition(Position.POSITION10);
        tictactoe.putPosition(Position.POSITION11);
        tictactoe.putPosition(Position.POSITION12);
        tictactoe.putPosition(Position.POSITION20);
        tictactoe.putPosition(Position.POSITION21);
        tictactoe.putPosition(Position.POSITION22);
        assertEquals(OutputMessage.draw, tictactoe.putPosition(Position.POSITION00));
    }


}

