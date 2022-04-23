package main.java;

import javafx.application.Application;
import javafx.stage.Stage;
import main.java.controllers.SceneObject;
import main.java.game.gameModel.Game;
import main.java.game.gameModel.IGame;

import java.util.Hashtable;

public class Jxtris extends Application {

    Hashtable<String, SceneObject> allScenes = new Hashtable<>();

    public static void main(String[] args) {
//        launch(args);
        IGame game = new Game();
        System.exit(0);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        SceneObject home = new SceneObject(getClass().getResource("../resources/fxml/Home.fxml"));
        home.loadAll();
        allScenes.put(home.getFileName(), home);

        SceneObject gamemode = new SceneObject(getClass().getResource("../resources/fxml/Gamemode.fxml"));
        gamemode.loadAll();
        allScenes.put(gamemode.getFileName(), gamemode);

        SceneObject game = new SceneObject(getClass().getResource("../resources/fxml/Game.fxml"));
        game.loadAll();
        allScenes.put(game.getFileName(), game);

        home.controller.setup(primaryStage, allScenes);
        gamemode.controller.setup(primaryStage, allScenes);
        game.controller.setup(primaryStage, allScenes);

        primaryStage.setScene(home.scene);
        primaryStage.setTitle("Jxtris");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
