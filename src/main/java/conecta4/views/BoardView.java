package conecta4.views;

import conecta4.models.Game;
import conecta4.types.Coordinate;

class BoardView {

    void write(Game game) {
        Message.HORIZONTAL_LINE.writeln();
        for (int i = Coordinate.ROW - 1; i >= 0; i--) {
            Message.VERTICAL_LINE.write();
            for (int j = 0; j < Coordinate.COL; j++) {
                new ColorView().write(game.getColor(new Coordinate(i, j)));
                Message.VERTICAL_LINE.write();
            }
            Message.JUMP_LINE.write();
        }
        Message.HORIZONTAL_LINE.writeln();
    }

}
