package src.View;

import javafx.application.Application;
import javafx.stage.Stage;
import src.Model.Game;

public class View extends Application {
    static Game game;

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    public static void create(Game g) {
        game = g;
        launch();
    }
}
