package conecta4.views;


public enum Message {
    TITLE("--- CONNECT 4 ---"),
    HORIZONTAL_LINE("---------------"),
    VERTICAL_LINE(" | "),
    JUMP_LINE("\n"),
    ENTER_COLUMN_TO_PUT("Enter a column to put a token:"),
    THIS_COLUMN_IS_FULL("This column is full, choose another column plz"),
    GAME_IS_DRAW("This game is a draw"),
    PLAYER_WIN(" : You win!!! :-)"),
    RESUME("Do you want to continue");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    void write() {
        System.out.print(this.message);
    }

    void writeln() {
        System.out.println(this.message);
    }

    void writeln(String player) {
        System.out.println("player " + player + this.message);
    }
}
