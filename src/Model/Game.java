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

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
