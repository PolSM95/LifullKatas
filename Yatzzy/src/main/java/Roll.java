import java.util.ArrayList;
import java.util.List;

public class Roll {

    List <Dice> diceList = new ArrayList<>();

    public Roll(Dice dice1,Dice dice2, Dice dice3, Dice dice4, Dice dice5) {

        diceList.add(dice1);
        diceList.add(dice2);
        diceList.add(dice3);
        diceList.add(dice4);
        diceList.add(dice5);

    }

    public int chance (){

        int score = 0;

        for (Dice diceNumber: diceList) {
            score += diceNumber.valueDice;
        }
        return score;
    }
}
