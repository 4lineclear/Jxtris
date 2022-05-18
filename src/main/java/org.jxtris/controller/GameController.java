package org.jxtris.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import org.jxtris.framework.ScenicController;
import org.jxtris.game.base.Game;
import org.jxtris.game.controls.KeyPoller;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController extends ScenicController{
    Scene gamemode;
    @FXML
    Button playButton;
    @FXML
    GridPane mainPanel;
    @FXML
    Canvas canvas;

    @FXML
    public void backClick() {
        playButton.setDisable(false);
        setScene("Gamemode");
    }

    @FXML
    public void playClick() {
        playButton.setDisable(true);
    }

    @FXML
    public void initialize() {
        Game game = new Game();
        KeyPoller.getInstance().pollNode(canvas);
        KeyPoller.getInstance().pollGame(game);
    }
}
