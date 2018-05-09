package src.Model;

public class Game {
    Board board;
    public boolean inGame;
    Player[] players;
    int currentPlayer;

    public Game(Board board, Player[] players, int currentPlayer) {
        this.board = board;
        this.players = players;
        this.currentPlayer = currentPlayer;
        inGame = true;
    }
}
