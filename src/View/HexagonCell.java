package src.View;

import javafx.scene.shape.Polygon;
import src.Model.Cell;

public class HexagonCell extends Polygon {
    private Cell cell;
    private int i,j;

    private static int computecos(double coord0, double rayon, int cote, double rotation) {
        return (int) (coord0 + rayon * Math.cos(2 * cote * Math.PI / 6 + rotation));
    }
    private static int computesin(double coord0, double rayon, int cote, double rotation) {
        return (int) (coord0 + rayon * Math.sin(2 * cote * Math.PI / 6 + rotation));
    }

    public HexagonCell(int x , int y, double rayon, double rotation) {
        super(computecos(x,rayon,1,rotation),computesin(y,rayon,1,rotation),
                computecos(x,rayon,2,rotation),computesin(y,rayon,2,rotation),
                computecos(x,rayon,3,rotation),computesin(y,rayon,3,rotation),
                computecos(x,rayon,4,rotation),computesin(y,rayon,4,rotation),
                computecos(x,rayon,5,rotation),computesin(y,rayon,5,rotation),
                computecos(x,rayon,6,rotation),computesin(y,rayon,6,rotation));
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
