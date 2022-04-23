package main.java.controllers;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

import java.util.Hashtable;

public class GamemodeController extends BaseController{
    @FXML
    GridPane mainPanel;
    Scene home, game;
    @FXML
    public void backClick() {
        stage.setScene(home);
    }

    @FXML
    public void sprintClick() {
        stage.setScene(game);
    }

    @Override
    protected void setScenes(Hashtable<String, SceneObject> scenes) {
        home = scenes.get("Home.fxml").scene;
        game = scenes.get("Game.fxml").scene;
    }
}
