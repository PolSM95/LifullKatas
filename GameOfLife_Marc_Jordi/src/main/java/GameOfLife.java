import sun.plugin.dom.core.CoreConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameOfLife {

    private ArrayList <Coordinates> board;

    public GameOfLife(){

        board = new ArrayList<>();

    }

    public void add(int rows, int columns){
        Coordinates coordinates = new Coordinates(rows,columns);
        board.add(coordinates);
    }

    public int round() {

        ArrayList<Coordinates> temporalBoard = new ArrayList<>();
        temporalBoard.addAll(board);


        for(int cell = 0; cell <board.size(); cell++){
            Coordinates actualCoordinate = board.get(cell);

            ArrayList<Coordinates> actualPossibleNeighbours = actualCoordinate.CalculateNeighbour();
            int count = 0;

            for (int i = 0; i<actualPossibleNeighbours.size(); i++){

                if(board.contains(actualPossibleNeighbours.get(i))){
                    count ++;
                };
            }
            System.out.println("CELL: "+cell + "COUNT: "+count);

            if(count < 2 || count > 3){
                temporalBoard.remove(actualCoordinate);
                System.out.println(temporalBoard.size()+"--tempSize");
            }

        }
        board = temporalBoard;



        return board.size();
    }


}
