package src.Model;

public class IAPlayer extends Player {
    Oracle oracle;

    public IAPlayer(Board board, String name, int difficulty) {
        super(board, name);
        oracle = new Oracle(difficulty);
    }
}
