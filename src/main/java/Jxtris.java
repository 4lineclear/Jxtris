package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.controllers.GameController;
import main.java.controllers.GamemodeController;
import main.java.controllers.HomeController;
import main.java.controllers.SceneObject;

import java.util.ArrayList;
import java.util.Hashtable;

public class Jxtris extends Application {

    public static void main(String[] args) {
//        launch(args);
        System.out.println("testest 123");
    }
    Hashtable<String, SceneObject> allScenes = new Hashtable<>();
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
