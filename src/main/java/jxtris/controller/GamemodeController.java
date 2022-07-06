package jxtris.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import jxtris.pagicFX.PagicController;

public class GamemodeController extends PagicController {
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
