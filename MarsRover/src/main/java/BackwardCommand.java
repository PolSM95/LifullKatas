public class BackwardCommand implements Command {
    private Position position;

    public BackwardCommand(Position position) {
        this.position = position;
    }

    @Override
    public void execute() {
        position.moveBackwards();
    }
}
