import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOfLifeShould {

    @Test
    public void return_array_empty_if_only_one_seed(){
        GameOfLife gameOfLife = new GameOfLife();
        Seed seed = new Seed(0,0);
        ArrayList<Seed> actual = new ArrayList<>();
        actual.add(seed);
        assertEquals(true,gameOfLife.life(actual).isEmpty());
    }
    @Test
    public void return_array_empty_if_only_two_seed(){
        GameOfLife gameOfLife = new GameOfLife();
        Seed seed1 = new Seed(0,0);
        Seed seed2 = new Seed(1,0);
        ArrayList<Seed> actual = new ArrayList<>();
        actual.add(seed1);
        actual.add(seed2);
        assertEquals(true,gameOfLife.life(actual).isEmpty());
    }

}
