import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class YatzzyShould {

    @Test
    public void return_score_for_chance_category(){
        Game game = new Game();
        Roll roll = new Roll(Dice.FOUR, Dice.FIVE, Dice.FIVE, Dice.SIX, Dice.ONE);
        assertEquals(21,game.totalScore(roll, Category.chance));

    }
}
