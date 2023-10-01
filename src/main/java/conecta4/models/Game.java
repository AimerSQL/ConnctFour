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

    public Color getColor(Coordinate coordinate) {
        return this.board.getColor(coordinate);
    }

    public boolean areAllTokensOnBoard() {
        return this.turn.areAllTokensOnBoard();
    }

    public void putToken(Coordinate coordinate) {
        this.turn.putToken(coordinate);
    }

    public Error getPutTokenError(Coordinate coordinate) {
        return this.turn.getPutTokenError(coordinate);
    }

    public void moveToken(Coordinate origin, Coordinate target) {
        this.turn.moveToken(origin, target);
    }

    public Error getOriginMoveTokenError(Coordinate coordinate) {
        return this.turn.getOriginMoveTokenError(coordinate);
    }

    public Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
        return this.turn.getTargetMoveTokenError(origin, target);
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