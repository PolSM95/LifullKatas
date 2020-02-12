import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Pair extends Roll{

    public Pair(Dice dice1, Dice dice2, Dice dice3, Dice dice4, Dice dice5) {
        super(dice1, dice2, dice3, dice4, dice5);
    }

    @Override
    public int calculateScore() {
        Dice max = diceList.stream().max(Dice::compareTo).get();

        Map<Dice, Long> counted = diceList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        counted.values().removeIf(item -> item == 1);
        Dice targetDice = (Dice) counted.keySet().toArray()[counted.size()-1];

        return targetDice.valueDice*2;
    }
}
