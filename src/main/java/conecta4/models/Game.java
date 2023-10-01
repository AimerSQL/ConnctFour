package conecta4.models;

import conecta4.types.Color;
import conecta4.types.Coordinate;
import conecta4.types.Error;

public class Game {

    private Board board;
    private Turn turn;

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

    public boolean isConnectFour() {
        return this.board.isConnectFour(this.turn.getActiveColor());
    }

    public boolean isBoardFull() {
        return this.board.isBoardFull();
    }
    public Color getColor(Coordinate coordinate) {
        return this.board.getColor(coordinate);
    }

    public boolean isColumnFull(int col) {
        return this.turn.isColumnFull(col);
    }

    public void putToken(int col) {
        this.turn.putToken(col);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Game other = (Game) obj;
        if (board == null) {
            if (other.board != null)
                return false;
        } else if (!board.equals(other.board))
            return false;
        if (turn == null) {
            return other.turn == null;
        } else return turn.equals(other.turn);
    }

}