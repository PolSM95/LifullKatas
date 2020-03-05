import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Game_Should {
    private Game game;

    @Before
    public void initializeGame(){
        game = new Game();
    }

    @Test(expected=Exception.class)
    public void notAllowPlayerOToPlayFirst() throws Exception {
        game.play('O', 0, 0);
    }

    @Test(expected=Exception.class)
    public void notAllowPlayerXToPlayTwiceInARow() throws Exception
    {
        game.play('X', 0, 0);

        game.play('X', 1, 0);
    }

    @Test(expected=Exception.class)
    public void notAllowPlayerToPlayInLastPlayedPosition() throws Exception
    {
        game.play('X', 0, 0);

        game.play('O', 0, 0);
    }

    @Test(expected=Exception.class)
    public void notAllowPlayerToPlayInAnyPlayedPosition() throws Exception
    {
        game.play('X', 0, 0);
        game.play('O', 1, 0);

        game.play('X', 0, 0);
    }

    @Test
    public void declarePlayerXAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.play('X', 0, 0);
        game.play('O', 1, 0);
        game.play('X', 0, 1);
        game.play('O', 1, 1);
        game.play('X', 0, 2);

        char winner = game.winner();

        assertEquals('X', winner);
    }

    @Test
    public void declarePlayerOAsAWinnerIfThreeInTopRow() throws Exception
    {
        game.play('X', 2, 2);
        game.play('O', 0, 0);
        game.play('X', 1, 0);
        game.play('O', 0, 1);
        game.play('X', 1, 1);
        game.play('O', 0, 2);

        char winner = game.winner();

        assertEquals('O', winner);
    }

    @Test
    public void declarePlayerXAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.play('X', 1, 0);
        game.play('O', 0, 0);
        game.play('X', 1, 1);
        game.play('O', 0, 1);
        game.play('X', 1, 2);

        char winner = game.winner();

        assertEquals('X', winner);
    }

    @Test
    public void declarePlayerOAsAWinnerIfThreeInMiddleRow() throws Exception
    {
        game.play('X', 0, 0);
        game.play('O', 1, 0);
        game.play('X', 2, 0);
        game.play('O', 1, 1);
        game.play('X', 2, 1);
        game.play('O', 1, 2);

        char winner = game.winner();

        assertEquals('O', winner);
    }

    @Test
    public void declarePlayerXAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.play('X', 2, 0);
        game.play('O', 0, 0);
        game.play('X', 2, 1);
        game.play('O', 0, 1);
        game.play('X', 2, 2);

        char winner = game.winner();

        assertEquals('X', winner);
    }

    @Test
    public void declarePlayerOAsAWinnerIfThreeInBottomRow() throws Exception
    {
        game.play('X', 0, 0);
        game.play('O', 2, 0);
        game.play('X', 1, 0);
        game.play('O', 2, 1);
        game.play('X', 1, 1);
        game.play('O', 2, 2);

        char winner = game.winner();

        assertEquals('O', winner);
    }
}