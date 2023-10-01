package conecta4.models;

import conecta4.types.Color;
import conecta4.types.Coordinate;
import conecta4.types.Error;

class Player {

    private Color color;
    private Board board;
    private int putTokens;

    Player(Color color, Board board) {
        assert !color.isNull();
        assert board != null;

        this.color = color;
        this.board = board;
        this.putTokens = 0;
    }

    boolean isColumnFull(int col) {
        int i = 0;
        do {
            if (!board.isEmpty(new Coordinate(col, i))) {
                i++;
            } else {
                return true;
            }
        } while (i < Coordinate.ROW);
        return false;

    }

    void putToken(int column) {
        this.board.putToken(column, this.color);
    }

    Error getPutTokenError(Coordinate coordinate) {
        if (!this.board.isEmpty(coordinate)) {
            return Error.NOT_EMPTY;
        }
        return Error.NULL;
    }

    Color getColor() {
        return this.color;
    }

}