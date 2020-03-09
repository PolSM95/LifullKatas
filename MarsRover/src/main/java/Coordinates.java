public class Coordinates {
    private int xCoordinate;
    private int yCoordinate;
    char orientation;

    public Coordinates(int xCoordinate, int yCoordinate, char orientation) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.orientation = orientation;
    }

    void updateOrientation(char[] commandArray) {
        switch (orientation) {
            case 'E':
                if (commandArray[0] == 'L') {
                    this.orientation = 'N';
                }
                if (commandArray[0] == 'R') {
                    this.orientation = 'S';
                }
                break;
            case 'W':
                if (commandArray[0] == 'L') {
                    this.orientation = 'S';
                }
                if (commandArray[0] == 'R') {
                    this.orientation = 'N';
                }
                break;
            case 'S':
                if (commandArray[0] == 'L') {
                    this.orientation = 'E';
                }
                if (commandArray[0] == 'R') {
                    this.orientation = 'W';
                }

                break;
            case 'N':
                if (commandArray[0] == 'L') {
                    this.orientation = 'W';
                }
                if (commandArray[0] == 'R') {
                    this.orientation = 'E';
                }

                break;


        }
    }

    public char getOrientation() {
        return orientation;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }
}