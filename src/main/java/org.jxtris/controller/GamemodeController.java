package org.jxtris.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import org.jxtris.framework.ScenicController;

public class GamemodeController extends ScenicController {
    @FXML
    GridPane mainPanel;

    @FXML
    public void backClick() {
        setScene("Home");
    }

    @FXML
    public void sprintClick() {
        setScene("Game");
    }

}
