public enum OutputMessage {
    turnO ("TURN o"),
    turnX ("TURN x"),
    win ("YOU ARE THE WINNER!!"),
    taken ("POSITION ALREADY TAKEN"),
    draw ("DRAW");
    public final String message;
    OutputMessage(String message){
        this.message = message;
    }
}
