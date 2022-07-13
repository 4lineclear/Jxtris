package jxtris.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import jxtris.game.state.controls.KeyPoller;
import jxtris.pagicFX.PagicController;

public class GameController extends PagicController {
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
        KeyPoller.getInstance().pollNode(canvas);
    }
}
