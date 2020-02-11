import java.util.ArrayList;
import java.util.List;

public abstract class Roll {

    List <Dice> diceList = new ArrayList<>();

    public Roll(Dice dice1,Dice dice2, Dice dice3, Dice dice4, Dice dice5) {
        diceList.add(dice1);
        diceList.add(dice2);
        diceList.add(dice3);
        diceList.add(dice4);
        diceList.add(dice5);
    }

    public abstract int calculateScore();

    public int yatzy (){
        if(diceList.stream().distinct().count() == 1){
            return 50;
        }
        return 0;
    }
    public int ones(){
       return (int)diceList.stream().filter(dice -> Dice.ONE.equals(dice)).count();
    }
}
