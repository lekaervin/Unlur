package src.Model;

import javafx.scene.paint.Color;

public class Game {
    Board board;
    public boolean inGame;
    Player[] players = new Player[2];
    int currentPlayer;
    boolean firstphase;

    public Game(Board board) {
        this.board = board;
        this.init2Players("Alex","Kirill");
        this.setCurrentPlayer(1);
        this.inGame = true;
        this.firstphase = true;
    }

    public boolean isFirstphase() {
        return firstphase;
    }

    public void setFirstphase(boolean firstphase) {
        this.firstphase = firstphase;
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

    public Player getCurrentPlayer() {
        return this.players[currentPlayer-1];
    }

    private void init2Players(String name1, String name2){
        this.players[0] = new RealPlayer(board,name1);
        this.players[1] = new RealPlayer(board,name2);
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void play (Cell c){
        if(this.isFirstphase()){
            c.setColor(Color.BLACK);
        }else{
            c.setColor(this.getCurrentPlayer().getColor());
        }
        this.nextPlayer();
    }

    public void nextPlayer(){
        if(this.currentPlayer==1){
            this.setCurrentPlayer(2);
        }else{
            this.setCurrentPlayer(1);
        }
    }

    public void pass(){
        this.setFirstphase(false);
        this.getCurrentPlayer().setColor(Color.BLACK);
        this.nextPlayer();
        this.getCurrentPlayer().setColor(Color.WHITE);
    }
}
