public class Game {
    private char lastSymbol = ' ';
    Board board = new Board();

    public void play(char symbol, int xCoordinate, int yCoordinate) throws Exception {
        //if first move
        //if player is X
        if (lastSymbol == ' ' && symbol == 'O') {
            throw new Exception("Invalid first player");
        }
        //if not first move but player repeated
        if (symbol == lastSymbol) {
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile

        Tile tile = new Tile(xCoordinate, yCoordinate, Board.SYMBOL_DEFAULT);
        if (!board.tileAt(tile).hasSameSymbol(tile)) {
            throw new Exception("Invalid position");
        }

        // update game state
        lastSymbol = symbol;
        board.updateTileAt(symbol, xCoordinate, yCoordinate);
    }

    public char winner() {
        return board.winner();
    }
}
