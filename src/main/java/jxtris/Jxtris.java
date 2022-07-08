package jxtris;

import javafx.application.Application;
import javafx.stage.Stage;
import jxtris.game.base.state.Block;
import jxtris.game.base.state.Matrix;
import jxtris.game.base.state.Mino;
import jxtris.game.base.state.Rotation;
import jxtris.pagicFX.AutoApplication;
import jxtris.pagicFX.Page;
import jxtris.pagicFX.PagicApplication;
import jxtris.pagicFX.PagicStage;

import java.io.IOException;

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
//        launch(args);
        Matrix matrix = new Matrix();
        Mino mino = new Mino();
        mino.type = Block.I;
        mino.rotation = Rotation.Start;
        matrix.addMino(mino, 1, 22);
        matrix.addMino(mino, 6, 22);

        matrix.addMino(mino, 2, 21);
        matrix.addMino(mino, 6, 21);

        matrix.addMino(mino, 2, 20);
        matrix.addMino(mino, 6, 20);

        matrix.addMino(mino, 1, 19);
        matrix.addMino(mino, 6, 19);
        mino.rotation = Rotation.Left;
        matrix.addMino(mino,0,20);
//        mino.type = Block.O;
//        matrix.addMino(mino, 0, 22);
        matrix.print();
    }

    /**
     * Method given by JavaFX {@link PagicApplication}
     * <p>
     * Drives JavaFX code
     * </p>
     *
     * @param stage The stage given by {@link PagicStage}
     * @throws IOException most likely file is not found
     **/
    @Override
    public void start(PagicStage stage) {
        stage.setPage("Home");
        stage.setTitle("Jxtris");
        stage.setResizable(false);
        stage.show();
    }
}
