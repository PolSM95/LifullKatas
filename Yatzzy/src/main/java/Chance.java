public class Chance extends Roll {

    public Chance(Dice dice1, Dice dice2, Dice dice3, Dice dice4, Dice dice5) {
        super(dice1, dice2, dice3, dice4, dice5);
    }

    @Override
    public int calculateScore() {
        int score = 0;

        for (Dice diceNumber: diceList) {
            score += diceNumber.valueDice;
        }
        return score;
    }
}
