package src.View;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import src.Model.Board;
import src.Model.Cell;
import src.Model.Game;

public class View extends Application {
    private final int X_START = 250;
    private final int Y_START = 50;
    static Game game;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Board board = game.getBoard();
        int yStart = Y_START;
        for(int i = 0; i < board.getSize();i++){
            int xStart = X_START - (15*i);
            for(Cell c : board.getBoard()[i]){
                if(c != null){
                    HexagonCell hexagonCell = new HexagonCell(xStart,yStart,15,Math.cos(45));
                    hexagonCell.setFill(Color.WHITE);
                    hexagonCell.setStroke(Color.BLACK);
                    hexagonCell.setStrokeWidth(1);
                    hexagonCell.setCell(c);
                    hexagonCell.setOnMouseEntered(entered -> {
                        hexagonCell.setStroke(Color.YELLOW);
                    });
                    hexagonCell.setOnMouseExited(exited -> {
                        hexagonCell.setStroke(Color.BLACK);
                    });
                    root.getChildren().add(hexagonCell);
                    xStart += 30;
                }
            }
            yStart += 30;
        }
        /*for(int i = board.getSize(); i < board.getSize()*2-1;i++){
            int xStart = X_START - (15*i);
            for(Cell c : board.getBoard()[i]){
                if(c != null){
                    HexagonCell hexagonCell = new HexagonCell(xStart,yStart,15,Math.cos(45));
                    hexagonCell.setFill(Color.WHITE);
                    hexagonCell.setStroke(Color.BLACK);
                    hexagonCell.setStrokeWidth(1);
                    hexagonCell.setCell(c);
                    root.getChildren().add(hexagonCell);
                    xStart += 30;
                }
            }
            yStart += 30;
        }*/
        primaryStage.setTitle("Unlur");
        Scene scene = new Scene(root,800,800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void create(Game g) {
        game = g;
        launch();
    }
}
