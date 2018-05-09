package src.Model;

public abstract class Player {
    Board board;
    int numPlayer;
    String name;
    Color color;

    public Player() {
    }

    public Player(Board board, int numPlayer, String name) {
        this.board = board;
        this.numPlayer = numPlayer;
        this.name = name;
        color = Color.noColor;
    }

    public void play(int line, int column) {
        board.play(line, column, color);
    }
}
