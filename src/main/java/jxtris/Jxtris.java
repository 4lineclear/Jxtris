package jxtris;

import javafx.application.Application;
import javafx.stage.Stage;
import jxtris.game.base.state.BaseGame;
import jxtris.game.base.state.Block;
import jxtris.game.base.state.GameState;
import jxtris.game.base.state.piece.MinoQueue;
import jxtris.pagicFX.AutoApplication;
import jxtris.pagicFX.PagicApplication;
import jxtris.pagicFX.PagicStage;

import java.util.Arrays;

/**
 * Driver class, contains the startup of JavaFX
 * <p>
 * Extends {@link PagicApplication} instead of {@link Application}
 * since this is a multi page app
 * </p>
 **/
public class Jxtris extends AutoApplication {

    /**
     * Driver function, launches {@link Jxtris#start(Stage)} using {@link Application#launch(String...)}
     **/
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Method given by JavaFX {@link PagicApplication}
     * <p>
     * Drives JavaFX code
     * </p>
     *
     * @param stage The stage given by {@link PagicStage}
     **/
    @Override
    public void start(PagicStage stage) {
        stage.setPage("Home");
        stage.setTitle("Jxtris");
        stage.setResizable(false);
        stage.show();
    }
}
