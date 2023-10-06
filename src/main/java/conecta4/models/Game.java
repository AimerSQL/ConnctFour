package conecta4.models;

import conecta4.types.Color;
import conecta4.types.Coordinate;

public class Game {

    private final Board board;
    private final Turn turn;
    private String test9;

    public Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public void reset() {
        this.board.reset();
        this.turn.reset();
    }

    public void next() {
        this.turn.next();
    }

    public Color getActiveColor() {
        return this.turn.getActiveColor();
    }

    public boolean isConnectFour() {return this.board.isConnectFour(this.turn.getActiveColor());}

    public boolean isBoardFull() {return this.board.isBoardFull();}

    public Color getColor(Coordinate coordinate) {return this.board.getColor(coordinate);}

    public boolean isColumnFull(int col) {return this.turn.isColumnFull(col);}

    public void putToken(int col) {
        this.turn.putToken(col);
    }

}