package src.Controller;

import src.Model.*;
import src.View.View;

public class Controller {

    public Controller() {
    }

    public void run() {
        Game game = createGame();
        View.create(game);
    }

    private Game createGame() {
        // Crée le plateau de jeu
        Board board = new Board();

        // Pour chaque joueur Crée un joueur IA ou réel
        Player[] players = new Player[2];
        players[0] = new RealPlayer(board, 0, "Alex");
        players[1] = new IAPlayer(board, 1, "IA1", 1);

        return new Game(board, players, 0);
    }

}
