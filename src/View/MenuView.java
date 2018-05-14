package src.View;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuView extends Application {

    @FXML
    Button buttonTest;

    @FXML
    CheckBox checkTest;

    public MenuView() throws IOException {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("View/MenuView.fxml"));
    }

    public static InfoGame show() {
        InfoGame ig = new InfoGame();
        ig.set(buttonTest);
        launch();
    }
}
