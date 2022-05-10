package org.jxtris.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import org.jxtris.framework.ScenicController;

public class GameController extends ScenicController {
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
        setScene("Gamemode");
    }

    @FXML
    public void playClick() {
        playButton.setDisable(true);
    }

}
