import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeCalisthenicsShould {

    @Test
    public void starting_the_game_with_player_x(){
        TicTacToe tictactoe = new TicTacToe();
        assertEquals(OutputMessage.afterX,tictactoe.putPosition(Position.POSITION00));
        
    }


}
