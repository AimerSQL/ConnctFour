package conecta4.models;

import conecta4.types.Color;

public class Turn {

    private final Board board;
    public static final int NUMBER_PLAYERS = 2;
    private final Player[] players;
    private int activePlayer;

    Turn(Board board) {
        assert board != null;
        this.board = board;
        this.players = new Player[Turn.NUMBER_PLAYERS];
        this.reset();
    }

    void reset() {
        for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
            this.players[i] = new Player(Color.get(i), this.board);
        }
        this.activePlayer = 0;
    }

    void next() {
        if (!this.board.isConnectFour(this.getActiveColor())) {
            this.activePlayer = (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;
        }
    }

    Player getActivePlayer() {
        return this.players[this.activePlayer];
    }

    Color getActiveColor() {
        return this.getActivePlayer().getColor();
    }

    boolean isColumnFull(int col) {
        return this.getActivePlayer().isColumnFull(col);
    }

    void putToken(int col) {
        this.getActivePlayer().putToken(col);
    }

}