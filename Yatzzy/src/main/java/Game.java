import java.util.ArrayList;
import java.util.List;

public class Game {
    public int totalScore(Roll roll,Category category) {
        if(category == Category.CHANCE){
            return roll.chance();
        }
        return roll.yatzy();
    }
}
