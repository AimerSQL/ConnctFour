package conecta4;

import conecta4.models.Game;
import conecta4.views.View;

class ConectaCuatro {

    private Game game;
    private View view;

    ConectaCuatro() {
        this.game = new Game();
        this.view = new View(this.game);
    }

    private void play() {
        do {

            this.view.start();//DIBUJAR TABLERO
            this.view.play();
        } while (this.view.resume());
    }

    public static void main(String[] args) {
        new ConectaCuatro().play();
    }

}