package conecta4.views;

import conecta4.models.Game;

class PlayView extends WithGameView {

    PlayView(Game game) {
        super(game);
    }

    void interact() {
        do {
            new PlayerView(this.game).interact();
            this.game.next();
            new BoardView().write(this.game);
        } while (!this.game.isConnectFour() && !this.game.isBoardFull());
        Message.PLAYER_WIN.writeln(this.game.getActiveColor().name());
    }

}