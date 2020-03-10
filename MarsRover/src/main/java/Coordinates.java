public class Coordinates {
    int xCoordinate;
    int yCoordinate;
    private final static int X_COORDINATE_LIMIT = 20;
    private final static int Y_COORDINATE_LIMIT = 20;

    public Coordinates(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public void moveUp(){
        this.yCoordinate++;
        if(yCoordinate > Y_COORDINATE_LIMIT){
            this.yCoordinate = 0;
        }
    }
    public void moveDown(){
        this.yCoordinate--;
        if(yCoordinate < 0 ){
            this.yCoordinate = Y_COORDINATE_LIMIT;
        }
    }
    public void moveLeft(){
        this.xCoordinate--;
        if(xCoordinate < 0){
            this.xCoordinate = X_COORDINATE_LIMIT;
        }
    }
    public void moveRight(){
        this.xCoordinate++;
        if(xCoordinate > X_COORDINATE_LIMIT){
            this.xCoordinate = 0;
        }
    }
}