import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TwoPair extends Roll {

    public TwoPair(Dice dice1, Dice dice2, Dice dice3, Dice dice4, Dice dice5) {
        super(dice1, dice2, dice3, dice4, dice5);
    }

    @Override
    public int calculateScore() {

        Map<Dice, Long> counted = diceList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        counted.values().removeIf(item -> item == 1);

        if(counted.size() == 2){

            Dice targetDice1 = (Dice) counted.keySet().toArray()[0];
            Dice targetDice2= (Dice) counted.keySet().toArray()[1];

            return ((targetDice1.valueDice * 2) + (targetDice2.valueDice * 2));
        }

        return 0;
    }
}
