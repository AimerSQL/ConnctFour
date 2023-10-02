package conecta4.models;

import conecta4.types.Color;
import conecta4.types.Coordinate;
class Player {

    private final Color color;
    private final Board board;

    Player(Color color, Board board) {
        assert !color.isNull();
        assert board != null;

        this.color = color;
        this.board = board;
    }

    boolean isColumnFull(int col) {
        int i = 0;
        do {
            if (!board.isEmpty(new Coordinate(i, col))) {
                i++;
            } else {
                return false;
            }
        } while (i < Coordinate.ROW);
        return true;

    }

    void putToken(int column) {
        this.board.putToken(column, this.color);
    }

    Color getColor() {
        return this.color;
    }

}