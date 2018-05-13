package src.Model;

import javafx.scene.shape.Polygon;

public class Cell extends Polygon {
    // Infos bordures
    final static int BORDER_NO = 0;
    final static int BORDER_TOP = 1;
    final static int BORDER_TOP_RIGHT = 2;
    final static int BORDER_BOTTOM_RIGHT = 4;
    final static int BORDER_BOTTOM = 8;
    final static int BORDER_BOTTOM_LEFT = 16;
    final static int BORDER_TOP_LEFT = 32;

    // Accès voisins
    final static int TOP_RIGHT = 0;
    final static int RIGHT = 1;
    final static int BOTTOM_RIGHT = 2;
    final static int BOTTOM_LEFT = 3;
    final static int LEFT = 4;
    final static int TOP_LEFT = 5;

    Cell [] neighbourgs;
    int border;
    Color color;

    public Cell() {
        neighbourgs = new Cell[6];
        border = 0;
        color = Color.noColor;
    }

    public boolean IsOnBorder() {
        return (this.border != BORDER_NO);
    }
}
