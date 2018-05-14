package src.Model;
import javafx.scene.paint.Color;

public abstract class Player {
    Board board;
    String name;
    Color color;

    public Player(Board board, String name) {
        this.board = board;
        this.name = name;
        color = null;
    }

//    public void play(int line, int column) {
//        board.play(line, column, color);
//    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}