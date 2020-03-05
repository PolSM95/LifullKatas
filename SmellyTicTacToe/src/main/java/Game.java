public class Game {
    private char lastSymbol = ' ';
    Board board = new Board();

    public void play(char symbol, int xCoordinate, int yCoordinate) throws Exception {
        //if first move
        if (lastSymbol == ' ') {
            //if player is X
            if (symbol == 'O') {
                throw new Exception("Invalid first player");
            }
        }
        //if not first move but player repeated
        else if (symbol == lastSymbol) {
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (board.tileAt(new Tile(xCoordinate, yCoordinate, Board.SYMBOL_DEFAULT)).symbol != ' ') {
            throw new Exception("Invalid position");
        }

        // update game state
        lastSymbol = symbol;
        board.addTileAt(symbol, xCoordinate, yCoordinate);
    }

    public char winner() {
        return board.winner();
    }
}
