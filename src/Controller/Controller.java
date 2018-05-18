package src.Controller;

import src.Model.*;
import src.View.View;

public class Controller {
    private Game game;

    public Controller() {
    }

    public void run() {
        this.game = createGame();
        View.show(game);
    }

    private Game createGame() {
        // Crée le plateau de jeu
        Board board = new Board();

        // Pour chaque joueur Crée un joueur IA ou réel

        return new Game(board);
    }

}
