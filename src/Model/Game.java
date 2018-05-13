package src.Model;

import java.util.ArrayList;
import java.util.List;

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


    public boolean testVictory(Cell current) {
        List<Cell> listCell = new ArrayList<Cell>();
        int res = testVictoryRec(current, listCell);
        if (players[currentPlayer].color == Color.black) {
            int solution1 = (Cell.BORDER_TOP + Cell.BORDER_BOTTOM_RIGHT + Cell.BORDER_BOTTOM_LEFT);
            int solution2 = (Cell.BORDER_TOP_RIGHT + Cell.BORDER_BOTTOM + Cell.BORDER_TOP_LEFT) ;
            return ((solution1 | res) == solution1 || (solution2 | res) == solution2);
        } else {
            int sol1 = (Cell.BORDER_BOTTOM + Cell.BORDER_TOP) ;
            int sol2 = (Cell.BORDER_BOTTOM_LEFT + Cell.BORDER_TOP_RIGHT);
            int sol3 = (Cell.BORDER_BOTTOM_RIGHT + Cell.BORDER_TOP_LEFT);
            return (((sol1 | res) == sol1) || ((sol2 | res) == sol2) || ((sol3 | res) == sol3));
        }
    }


    public int testVictoryRec(Cell current, List<Cell> listCell) {
        int res = 0;
        if (current.IsOnBorder()) {
            res = current.border;
        }
        for (int i = 0; i <= Cell.TOP_LEFT; i++) {
            if (current.neighbours[i].color == players[currentPlayer].color & !(listCell.contains(current.neighbours[i]))) {
                listCell.add(current.neighbours[i]);
                res = res | testVictoryRec(current.neighbours[i], listCell);
            }
        }
        return res;
    }
}
