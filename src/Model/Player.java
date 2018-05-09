package src.Model;

public abstract class Player {
    Board board;
    int numPlayer;
    Color color;

    public Player() {
    }

    public Player(Board board, int numPlayer) {
        this.board = board;
        this.numPlayer = numPlayer;
        color = Color.noColor;
    }

    public void play(int line, int column) {
        board.play(line, column, color);
    }
}
