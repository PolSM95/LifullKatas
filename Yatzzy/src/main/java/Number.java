public class Number extends Roll{

    Dice number;

    public Number(Dice dice1, Dice dice2, Dice dice3, Dice dice4, Dice dice5, Dice number) {
        super(dice1, dice2, dice3, dice4, dice5);
        this.number = number;
    }

    @Override
    public int calculateScore() {
        return (((int)diceList.stream().filter(dice -> number.equals(dice)).count())*number.valueDice);
    }

}
