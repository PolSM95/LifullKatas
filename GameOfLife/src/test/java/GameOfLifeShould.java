import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOfLifeShould {

    @Test
    public void evolve_to_an_empty_universe_from_one_Cell_universe(){

        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.addCell(new Cell(0,1));
        GameOfLife nextExpected = new GameOfLife();

        gameOfLife.nextRound();

        assertEquals(nextExpected, gameOfLife);

    }
}
