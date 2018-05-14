package src.View;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import src.Model.Board;
import src.Model.Cell;
import src.Model.Game;

public class View extends Application {
    private final int X_START = 0;
    private final int Y_START = 0;
    private final int RAYON = 30;
    private final double HIGHT = RAYON*1.7;
    static Game game;

    private void configHexa(HexagonCell h,Cell c,Scene scene){
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
            if(h.getCell().getColor()==null)
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
//        h.translateXProperty().bind(scene.widthProperty().divide(3));
//        h.translateYProperty().bind(scene.heightProperty().divide(10));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
//        Group all = new Group();
        GridPane grid = new GridPane();
        grid.setStyle("-fx-background-color : black");
//        all.getChildren().add(grid);
        Scene scene = new Scene(grid,800,800);
        grid.setAlignment(Pos.CENTER);
        Board board = game.getBoard();
        int yStart = Y_START;
        for(int i = 0; i < board.getSize();i++){
            int xStart = X_START - (RAYON*i);
            for(Cell c : board.getBoard()[i]){
                if(c != null){
                    HexagonCell hexagonCell = new HexagonCell(xStart,yStart,RAYON,Math.cos(45));
                    configHexa(hexagonCell,c,scene);
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
                    configHexa(hexagonCell,c,scene);
                    root.getChildren().add(hexagonCell);
                    xStart += RAYON*2;
                }
            }
            yStart += HIGHT;
        }
        primaryStage.setTitle("Unlur");
        grid.add(root,0,0);
        HBox boxButton = new HBox();
        boxButton.setAlignment(Pos.CENTER);
        Button pass = new Button("Pass");
        pass.setOnAction(action ->{
            game.pass();
            grid.getChildren().remove(boxButton);
        });
        boxButton.getChildren().add(pass);
        grid.add(boxButton,0,1);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void show(Game g) {
        game = g;
        launch();
    }
}
