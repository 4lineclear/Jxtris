package main.java.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import main.java.framework.ScenicController;

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
