package conecta4.views;

import conecta4.types.Color;
import utils.views.Console;

class ColorView {

    void write(Color color) {
        String string = color.name();
        if (color.isNull()) {
            string = " ";
        }
        Console.getInstance().write(string);
    }

}