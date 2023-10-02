package conecta4.views;

import conecta4.models.Game;

import java.util.Scanner;

class ResumeView extends WithGameView {

    private static final char AFFIRMATIVE = 'y';
    private static final char NEGATIVE = 'n';
    private static final String SUFFIX = "? (" +
            ResumeView.AFFIRMATIVE+"/" +
            ResumeView.NEGATIVE+"): ";
    private static final String MESSAGE = "The value must be '" +
            ResumeView.AFFIRMATIVE + "' or '" +
            ResumeView.NEGATIVE + "'";
    private String answer = "y";

    ResumeView(Game game) {
        super(game);
    }

    boolean interact() {
        Message.RESUME.write();
        read();
        if (isAffirmative()) {
            this.game.reset();
        }
        return isAffirmative();
    }

    public void read() {
        boolean ok;
        do {
            System.out.print(ResumeView.SUFFIX);
            Scanner scanner = new Scanner(System.in);
            answer = scanner.nextLine();
            ok = this.isAffirmative() || this.isNegative();
            if (!ok) {
                System.out.print(ResumeView.MESSAGE);
            }
        } while (!ok);
    }

    public boolean isAffirmative() {
        return this.getAnswer() == ResumeView.AFFIRMATIVE;
    }

    private char getAnswer(){
        return Character.toLowerCase(this.answer.charAt(0));
    }

    public boolean isNegative() {
        return this.getAnswer() == ResumeView.NEGATIVE;
    }

}