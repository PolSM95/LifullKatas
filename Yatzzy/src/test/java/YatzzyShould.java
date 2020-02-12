import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class YatzzyShould {

    @Test
    public void return_score_for_chance_category(){
        Game game = new Game();
        Chance roll = new Chance(Dice.FOUR, Dice.FIVE, Dice.FIVE, Dice.SIX, Dice.ONE);
        assertEquals(21,game.totalScore(roll, Category.CHANCE));
    }
    @Test
    public void return_max_score_for_yatzy_category(){
        Game game = new Game();
        Yatzy yatzy = new Yatzy(Dice.ONE, Dice.ONE, Dice.ONE, Dice.ONE, Dice.ONE);
        assertEquals(50,game.totalScore(yatzy, Category.YATZY));
    }
    @Test
    public void return_min_score_for_yatzy_category(){
        Game game = new Game();
        Yatzy yatzy = new Yatzy(Dice.ONE, Dice.TWO, Dice.ONE, Dice.ONE, Dice.ONE);
        assertEquals(0,game.totalScore(yatzy, Category.YATZY));
    }


    @Test
    public void return_sum_of_the_total_of_ones_in_one_category(){
        Game game = new Game();
        Number number = new Number(Dice.ONE, Dice.ONE, Dice.TWO, Dice.FOUR, Dice.FOUR, Dice.ONE);
        assertEquals(2,game.totalScore(number, Category.ONES));
    }

    @Test
    public void return_score_when_there_is_a_pair_in_the_roll(){
        Game game = new Game();
        Pair pair = new Pair(Dice.FOUR, Dice.FOUR, Dice.ONE,Dice.FOUR, Dice.ONE);
        assertEquals(8,game.totalScore(pair, Category.ONES));
    }

    @Test
    public void return_score_when_there_are_two_pairs_in_the_roll(){
        Game game = new Game();
        TwoPair twopair = new TwoPair(Dice.FOUR, Dice.FOUR, Dice.ONE,Dice.FOUR, Dice.ONE);
        assertEquals(10,game.totalScore(twopair, Category.ONES));
    }
}
