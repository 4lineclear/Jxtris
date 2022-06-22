package jxtris.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import jxtris.game.Game;
import jxtris.game.base.controls.KeyPoller;
import jxtris.game.gamemode.GenericGame;
import jxtris.framework.ScenicController;
import jxtris.game.base.glue.GameBus;
import jxtris.game.base.rendering.RenderBus;
import jxtris.game.base.rendering.Renderer;
import jxtris.game.base.state.BaseGame;

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
        BaseGame game = new GenericGame();
        GameBus gameBus = new GameBus(game);
        Renderer renderer = new Renderer();
        RenderBus renderBus = new RenderBus();
        Game assembledGame = new Game(game, gameBus, renderer, renderBus);
        KeyPoller.getInstance().pollNode(canvas);
        assembledGame.start();
    }
}
