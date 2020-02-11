import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class YatzzyShould {

    @Test
    public void return_score_for_chance_category(){
        Game game = new Game();
        Roll roll = new Roll(Dice.FOUR, Dice.FIVE, Dice.FIVE, Dice.SIX, Dice.ONE);
        assertEquals(21,game.totalScore(roll, Category.CHANCE));
    }
    @Test
    public void return_max_score_for_yatzy_category(){
        Game game = new Game();
        Roll roll = new Roll(Dice.ONE, Dice.ONE, Dice.ONE, Dice.ONE, Dice.ONE);
        assertEquals(50,game.totalScore(roll, Category.YATZY));
    }
    @Test
    public void return_min_score_for_yatzy_category(){
        Game game = new Game();
        Roll roll = new Roll(Dice.ONE, Dice.TWO, Dice.ONE, Dice.ONE, Dice.ONE);
        assertEquals(0,game.totalScore(roll, Category.YATZY));
    }
}
