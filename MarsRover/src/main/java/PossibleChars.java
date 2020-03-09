public enum PossibleChars {
    LEFT('L'),
    RIGHT('R'),
    NORTH('N'),
    SOUTH('S'),
    EAST('E'),
    WEST('W');

    private char value;

    public char getValue() {
        return value;
    }

    PossibleChars(char value) {
        this.value = value;
    }
}