package src.Model;

public class Cell {
    // Infos bordures
    final static int NO_BORDER = 0;
    final static int TOP_BORDER = 1;
    final static int TOP_RIGHT_BORDER = 2;
    final static int BOTTOM_RIGHT_BORDER = 4;
    final static int BOTTOM_BORDER = 8;
    final static int BOTTOM_LEFT_BORDER = 16;
    final static int TOP_LEFT_BORDER = 32;

    // Accès voisins
    final static int TOP_RIGHT = 0;
    final static int RIGHT = 1;
    final static int BOTTOM_RIGHT = 2;
    final static int BOTTOM_LEFT = 3;
    final static int LEFT = 4;
    final static int TOP_LEFT = 5;

    int [] neighbourgs;
    int border;
    Color color;

    public Cell() {
        neighbourgs = new int[6];
        border = -1;
        color = Color.noColor;
    }
}
