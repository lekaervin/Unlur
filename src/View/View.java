package src.View;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import src.Model.Board;
import src.Model.Cell;
import src.Model.Game;

public class View extends Application {
    private final int X_START = 250;
    private final int Y_START = 50;
    private final int RAYON = 30;
    private final double HIGHT = RAYON*1.75;
    static Game game;

    private void configHexa(HexagonCell h,Cell c){
        h.setFill(Color.GRAY);
        h.setStrokeWidth(1);
        h.setCell(c);
        h.setOnMouseEntered(entered -> {
            if(h.getCell().getColor()== null){
                h.setStroke(Color.RED);
            }
        });
        h.setOnMouseExited(exited -> {
            if (h.getCell().getColor()== null) {
                h.setStroke(Color.BLACK);
            }
        });
        h.setOnMouseClicked(clicked ->{
            if (game.isFirstphase()) {
                h.setFill(Color.BLACK);
                game.play(c);
                h.setStroke(Color.WHITE);
            } else {
                h.setFill(game.getCurrentPlayer().getColor());
                game.play(h.getCell());
                h.setStroke(Color.WHITE);
            }
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Board board = game.getBoard();
        int yStart = Y_START;
        for(int i = 0; i < board.getSize();i++){
            int xStart = X_START - (RAYON*i);
            for(Cell c : board.getBoard()[i]){
                if(c != null){
                    HexagonCell hexagonCell = new HexagonCell(xStart,yStart,RAYON,Math.cos(45));
                    configHexa(hexagonCell,c);
                    root.getChildren().add(hexagonCell);
                    xStart += RAYON*2;
                }
            }
            yStart += HIGHT;
        }
        for(int i = board.getSize(); i < (board.getSize()*2)-1;i++){
            int xStart = X_START - (RAYON*(4+(6-i)));
            for(Cell c : board.getBoard()[i]){
                if(c != null){
                    HexagonCell hexagonCell = new HexagonCell(xStart,yStart,RAYON,Math.cos(45));
                    configHexa(hexagonCell,c);
                    root.getChildren().add(hexagonCell);
                    xStart += RAYON*2;
                }
            }
            yStart += HIGHT;
        }
        primaryStage.setTitle("Unlur");
        Scene scene = new Scene(root,800,800);
        Button pass = new Button("Pass");
        pass.setLayoutX(scene.getWidth()/2);
        pass.setLayoutY(scene.getHeight()-30);
        root.getChildren().add(pass);
        pass.setOnAction(action ->{
            game.pass();
            root.getChildren().remove(pass);
        });
        scene.setFill(Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void show(Game g) {
        game = g;
        launch();
    }
}
