package conecta4.views;

import conecta4.types.Color;

class ColorView {

    void write(Color color) {
        String string = color.name();
        if (color.isNull()) {
            string = " ";
        }
        System.out.print(string);
    }
}
