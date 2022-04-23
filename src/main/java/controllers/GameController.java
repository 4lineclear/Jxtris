package main.java.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.Hashtable;
import java.util.ResourceBundle;

public class GameController extends BaseController implements Initializable {
    Scene gamemode;
    @FXML
    Button playButton;
    @FXML
    GridPane mainPanel;
    @FXML
    AnchorPane canvasPanel;
    @FXML
    Canvas canvas;

    @FXML
    public void backClick() {
        playButton.setDisable(false);
        stage.setScene(gamemode);
    }

    @FXML
    public void playClick() {
        playButton.setDisable(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    protected void setScenes(Hashtable<String, SceneObject> scenes) {
        gamemode = scenes.get("Gamemode.fxml").scene;
    }
}
