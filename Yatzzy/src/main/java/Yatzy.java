public class Yatzy extends Roll{

    public Yatzy(Dice dice1, Dice dice2, Dice dice3, Dice dice4, Dice dice5) {
        super(dice1, dice2, dice3, dice4, dice5);
    }

    @Override
    public int calculateScore() {

        if(diceList.stream().distinct().count() == 1){
            return 50;
        }
        return 0;
    }
}
