package src.Model;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;

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
        if (this.testVictory(c)) {
            this.gameOver();
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

    private void gameOver(){
        System.out.println("GAME IS OVERRRRRR");
    }


/*    public boolean testVictory(Cell current) {
        List<Cell> listCell = new ArrayList<Cell>();
        listCell.add(current);
        int res = testVictoryRec(current, listCell);
        if (current.getColor() == Color.BLACK) {

            int solution1 = (Cell.BORDER_TOP + Cell.BORDER_BOTTOM_RIGHT + Cell.BORDER_BOTTOM_LEFT);
            System.out.println(solution1);
            int solution2 = (Cell.BORDER_TOP_RIGHT + Cell.BORDER_BOTTOM + Cell.BORDER_TOP_LEFT) ;
            System.out.println(solution2);
            System.out.println((res));
            System.out.println((solution1 & res)== solution1);
            return ((solution1 & res) == solution1 || (solution2 & res) == solution2);
        } else {
            int sol1 = (Cell.BORDER_BOTTOM + Cell.BORDER_TOP) ;
            int sol2 = (Cell.BORDER_BOTTOM_LEFT + Cell.BORDER_TOP_RIGHT);
            int sol3 = (Cell.BORDER_BOTTOM_RIGHT + Cell.BORDER_TOP_LEFT);
            System.out.println(sol1 + " " + sol2 + " " + sol3);
            return (((sol1 & res) == sol1) || ((sol2 & res) == sol2) || ((sol3 & res) == sol3));
        }
    }


    public int testVictoryRec(Cell current, List<Cell> listCell) {
        int res = 0;
        if (current.IsOnBorder()) {
            res = current.border;
        }
        for (int i = 0; i <= Cell.TOP_LEFT; i++) {
            if (current.neighbours[i] != null && current.neighbours[i].color == current.getColor() && !(listCell.contains(current.neighbours[i]))) {
                listCell.add(current.neighbours[i]);
                res = res | testVictoryRec(current.neighbours[i], listCell);
            }
        }
        return res;
    }*/


    public void majBorder(Cell current) {
        for(int i = Cell.TOP_RIGHT ; i <= Cell.TOP_LEFT ; i++) {
            if ((current.getNeighbour(i) != null) && (current.getNeighbour(i).getColor() == current.getColor()) && (current.getNeighbour(i).getBorder() != current.getBorder())) {
                current.getNeighbour(i).setBorder(current.getBorder());
                majBorder(current.getNeighbour(i));
            }
        }
    }


    public boolean testVictory(Cell current) {
        int currentBorder = current.getBorder();
        for (int i = Cell.TOP_RIGHT ; i <= Cell.TOP_LEFT ; i++ ) {
            if ((current.getNeighbour(i) != null) && (current.getNeighbour(i).getColor() == current.getColor())) {
                currentBorder = currentBorder | current.getNeighbour(i).getBorder();
            }
        }
        current.setBorder(currentBorder);
        majBorder(current);
        if (current.getColor() == Color.BLACK) {

            int solution1 = (Cell.BORDER_TOP + Cell.BORDER_BOTTOM_RIGHT + Cell.BORDER_BOTTOM_LEFT);
            System.out.println(solution1);
            int solution2 = (Cell.BORDER_TOP_RIGHT + Cell.BORDER_BOTTOM + Cell.BORDER_TOP_LEFT) ;
            System.out.println(solution2);
            System.out.println(currentBorder);
            return ((solution1 & currentBorder) == solution1 || (solution2 & currentBorder) == solution2);
        } else {
            int sol1 = (Cell.BORDER_BOTTOM + Cell.BORDER_TOP) ;
            int sol2 = (Cell.BORDER_BOTTOM_LEFT + Cell.BORDER_TOP_RIGHT);
            int sol3 = (Cell.BORDER_BOTTOM_RIGHT + Cell.BORDER_TOP_LEFT);
            System.out.println(sol1 + " " + sol2 + " " + sol3);
            return (((sol1 & currentBorder) == sol1) || ((sol2 & currentBorder) == sol2) || ((sol3 & currentBorder) == sol3));
        }
    }
}
