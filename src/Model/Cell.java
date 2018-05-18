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

    public Cell getNeighbour(int n) {
        return this.neighbours[n];
    }

    public void setNeighbour(Cell neighbour, int n) {
        this.neighbours[n] = neighbour;
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

    public boolean IsOnBorder() {
        return (this.border != BORDER_NO);
    }

    public void majBorder() {
        for(int i = Cell.TOP_RIGHT ; i <= Cell.TOP_LEFT ; i++) {
            if ((this.getNeighbour(i) != null) && (this.getNeighbour(i).getColor() == this.getColor()) && (this.getNeighbour(i).getBorder() != this.getBorder())) {
                this.getNeighbour(i).setBorder(this.getBorder());
                this.getNeighbour(i).majBorder();
            }
        }
    }


    public boolean testVictory() {
        int currentBorder = this.border;
        for (int i = Cell.TOP_RIGHT ; i <= Cell.TOP_LEFT ; i++ ) {
            if ((this.getNeighbour(i) != null) && (this.getNeighbour(i).getColor() == this.getColor())) {
                currentBorder = currentBorder | this.getNeighbour(i).getBorder();
            }
        }
        this.setBorder(currentBorder);
        this.majBorder();
        if (this.getColor() == Color.BLACK) {

            int solution1 = (Cell.BORDER_TOP + Cell.BORDER_BOTTOM_RIGHT + Cell.BORDER_BOTTOM_LEFT);
            System.out.println(solution1);
            int solution2 = (Cell.BORDER_TOP_RIGHT + Cell.BORDER_BOTTOM + Cell.BORDER_TOP_LEFT) ;
            System.out.println(solution2);
            System.out.println(currentBorder);
            return ((solution1 & currentBorder) == solution1 || (solution2 & currentBorder) == solution2);
        } else {
            int sol1 = (Cell.BORDER_BOTTOM + Cell.BORDER_TOP) ;
            int sol2 = (Cell.BORDER_BOTTOM_LEFT + Cell.BORDER_TOP_RIGHT);
            int sol3 = (Cell.BORDER_BOTTOM_RIGHT + Cell.BORDER_TOP_LEFT);
            System.out.println(sol1 + " " + sol2 + " " + sol3);
            return (((sol1 & currentBorder) == sol1) || ((sol2 & currentBorder) == sol2) || ((sol3 & currentBorder) == sol3));
        }
    }
    


}
