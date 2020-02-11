public enum Player {
    charX ('x'),
    charO ('o'),
    charEmpty (' ');

    public final char characterPlayer;
    Player(char characterPlayer){
        this.characterPlayer = characterPlayer;
    }
}
