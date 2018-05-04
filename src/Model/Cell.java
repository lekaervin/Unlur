package src.Model;

public class Cell {
    private int Color ; // 0 -> vide , 1 -> blanc , 2 -> noir
    private Cell cellBottom;
    private Cell cellUp;
    private Cell cellBottomRight;
    private Cell cellBottomLeft;
    private Cell cellUpRight;
    private Cell cellUpLeft;
    private int line;
    private int column;

    Cell(int Color, int line , int column ){
        this.Color = Color;
        this.line =line;
        this.column = column;
    }
    // les methodes get..
    public int getColor() {
        return Color;
    }

    public int getColumn() {
        return column;
    }

    public int getLine() {
        return line;
    }

    public Cell getCellBottom() {
        return cellBottom;
    }

    public Cell getCellBottomLeft() {
        return cellBottomLeft;
    }

    public Cell getCellBottomRight() {
        return cellBottomRight;
    }

    public Cell getCellUp() {
        return cellUp;
    }

    public Cell getCellUpLeft() {
        return cellUpLeft;
    }

    public Cell getCellUpRight() {
        return cellUpRight;
    }
    // les méthodes set...
    public void setLine(int line) {
        this.line = line;
    }

    public void setColor(int color) {
        Color = color;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setCellBottom(Cell cellBottom) {
        this.cellBottom = cellBottom;
    }

    public void setCellBottomLeft(Cell cellBottomLeft) {
        this.cellBottomLeft = cellBottomLeft;
    }

    public void setCellBottomRight(Cell cellBottomRight) {
        this.cellBottomRight = cellBottomRight;
    }

    public void setCellUp(Cell cellUp) {
        this.cellUp = cellUp;
    }

    public void setCellUpLeft(Cell cellUpLeft) {
        this.cellUpLeft = cellUpLeft;
    }

    public void setCellUpRight(Cell cellUpRight) {
        this.cellUpRight = cellUpRight;
    }

    // compare deux cellule de meme position

    public boolean equalPos(Cell c) {
        if (this.column ==  c.getColumn() && this.line == c.getLine() ){
            return this.Color == c.getColor();
        }else{
            return false;
        }
    }
}
