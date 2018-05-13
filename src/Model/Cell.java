package src.Model;

import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;

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

    Cell [] neighbours;
    int border;
    Color color;

    public Cell() {
        this.neighbours = new Cell[6];
        this.border = 0;
        this.color = null;
    }

    public Cell[] getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(Cell[] neighbours) {
        this.neighbours = neighbours;
    }

    public int getBorder() {
        return border;
    }

    public void setBorder(int border) {
        this.border = border;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
