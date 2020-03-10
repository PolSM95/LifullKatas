package MarsRover;

public enum PossibleChars {
    LEFT('L'),
    RIGHT('R'),
    FORWARD('F'),
    BACKWARDS('B');

    private char value;

    public char getValue() {
        return value;
    }

    PossibleChars(char value) {
        this.value = value;
    }
}