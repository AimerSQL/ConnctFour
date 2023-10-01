package conecta4.views;

import conecta4.models.Game;
import conecta4.types.Coordinate;
import conecta4.types.Error;

import java.util.Scanner;

class PlayerView {

    private Game game;

    PlayerView(Game game) {
        this.game = game;
    }

    void interact() {
        int col;
        Scanner scanner = new Scanner(System.in);
        do{
            Message.ENTER_COLUMN_TO_PUT.writeln();
            col = scanner.nextInt();
        }while(this.game.isColumnFull(col));
        this.game.putToken(col);
    }

}