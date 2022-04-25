package main.java;

import javafx.application.Application;
import javafx.stage.Stage;
import main.java.controllers.SceneObject;
import main.java.game.gameModel.Game;
import main.java.game.gameModel.IGame;

import java.util.Hashtable;

/**
 * Driver class, contains the startup of JavaFX and the creation of any MVC components
 **/
public class Jxtris extends Application {

    Hashtable<String, SceneObject> allScenes = new Hashtable<>();

    /**
     * Driver function, launches {@link Jxtris#start(Stage)}
     **/
    public static void main(String[] args) {
//        launch(args);
        IGame game = new Game();
        System.exit(0);
    }

    /**
     * Method given by JavaFX {@link Application}
     * <p>
     *     Also creates MVC components
     * </p>
     * @param primaryStage The stage given by JavaFX
     * @throws Exception could be literally anything
     **/
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
