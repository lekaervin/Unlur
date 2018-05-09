package src.Model;

public class IAPlayer extends Player {
    Oracle oracle;

    public IAPlayer(Board board, int numPlayer, String name, int difficulty) {
        super(board, numPlayer, name);
        oracle = new Oracle(difficulty);
    }
}
