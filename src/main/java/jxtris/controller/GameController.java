package jxtris.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import jxtris.game.Game;
import jxtris.game.controls.KeyPoller;
import jxtris.game.gamemodes.GenericGame;
import jxtris.game.gamemodes.GenericRenderer;
import jxtris.pagicFX.PagicController;

public class GameController extends PagicController {
    private Game game;
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
        game.start();
        playButton.setDisable(true);
    }

    @FXML
    public void initialize() {
        this.canvas.getGraphicsContext2D().setFill(Color.GRAY);
        this.canvas.getGraphicsContext2D().fillRect(0,0, canvas.getWidth(), canvas.getHeight());
        game = new Game(new GenericGame(), new GenericRenderer(this.canvas.getGraphicsContext2D()));
        KeyPoller.getInstance().pollNode(canvas);
    }
}
