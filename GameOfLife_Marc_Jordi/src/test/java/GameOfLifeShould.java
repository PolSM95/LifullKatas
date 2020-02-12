import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameOfLifeShould {

    @Test
    public void return_0_by_checking_that_one_only_cell_dies(){

        GameOfLife game = new GameOfLife();
        assertEquals(0, game.round());

    }
    @Test
    public void remove_cell_when_less_than_two_neighbours_and_return_alive_cells(){

        GameOfLife game = new GameOfLife();

        game.add(1,1);
        game.add(0,2);
        game.add(2,2);

        assertEquals(1, game.round());

    }
    @Test
    public void remove_cell_when_more_than_three_neighbours_and_return_alive_cells(){

        GameOfLife game = new GameOfLife();

        game.add(0,0);
        game.add(0,2);
        game.add(1,0);
        game.add(1,1);
        game.add(2,1);

        assertEquals(3, game.round());

    }


}
