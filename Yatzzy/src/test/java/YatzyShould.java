import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class YatzyShould {
    @Test
    public void return_score_for_chance_category(){
        Game game = new Game();
        Roll roll = new Roll(Dice.ONE, Dice.ONE, Dice.THREE,Dice.THREE, Dice.SIX);
        assertEquals(14,game.totalScore(roll,Category.chance));
    }
}
