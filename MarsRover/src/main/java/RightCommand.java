public class RightCommand implements Command {


    private Position position;

    public RightCommand(Position position) {


        this.position = position;
    }

    @Override
    public void execute() {
        position.rotateRight();
    }
}
