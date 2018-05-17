package src.View;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
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

    private void configHexa(HexagonCell h,Cell c){
        //Configuration des couleurs et les intéractions de souris


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
                game.play(h.getCell());
                h.setStroke(Color.WHITE);
            } else {
                h.setFill(game.getCurrentPlayer().getColor());
                game.play(h.getCell());
                h.setStroke(Color.WHITE);
            }
        });
    }

    private void constructHexaCells(Board board, Group root,Scene scene){
        //Deux boucles :
        // -- Première pour faire les cellules du haut
        // -- Deuxième pour faire les cellules du bas

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
    }

    private void constructIHM(GridPane grid){
        //Boutton pass
        HBox boxButton = new HBox();
        boxButton.setAlignment(Pos.CENTER);
        Button pass = new Button("Pass");
        pass.setOnAction(action ->{
            game.pass();
            grid.getChildren().remove(boxButton);
        });
        boxButton.getChildren().add(pass);
        grid.add(boxButton,0,1);
        //-------------------------------------------
        //Panels Joeurs
        GridPane joueur1 = new GridPane();
        joueur1.setStyle("-fx-background-color : grey");
        Text nom1 = new Text();
        nom1.setText("Baba Yaga");
        joueur1.add(nom1,0,0);
        Text couleur1 = new Text();
        couleur1.setText("Couleur : Rouge");
        joueur1.add(couleur1,0,1);
        grid.add(joueur1,0,0);
        GridPane joueur2 = new GridPane();
        joueur2.setStyle("-fx-background-color : grey");
        Text nom2 = new Text();
        nom2.setText("Baba Yaga");
        joueur2.add(nom2,0,0);
        Text couleur2 = new Text();
        couleur2.setText("Couleur : Rouge");
        joueur2.add(couleur2,0,1);
        grid.add(joueur2,2,0);
        //-------------------------------------------
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        //Instanciation des variables
        Group cells = new Group(); //Group d'objet , regroupant toutes les cullules
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid,800,800);
        Board board = game.getBoard();

        //Construction des cellules
        this.constructHexaCells(board,cells,scene);
        grid.add(cells,1,0);

        //Initialisation de l'IHM
        this.constructIHM(grid);

        //Style
        grid.setStyle("-fx-background-color : black");
        grid.setAlignment(Pos.CENTER);
        primaryStage.setTitle("Unlur");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void show(Game g) {
        game = g;
        launch();
    }
}
