package src.Model;

public class IAPlayer extends Player {
    Oracle oracle;

    public IAPlayer(Board board, int numPlayer, int difficulty) {
        super(board, numPlayer);
        oracle = new Oracle(difficulty);
    }

}
