package org.jxtris.framework;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The entry point class for Scenic JavaFX applications
 * <p>
 * Overrides {@link Application}, which launches the {@link Application#start(Stage)} method,
 * giving the user {@link Stage}. The {@link ScenicApplication} class
 * adds {@link ScenicApplication#scenicStart(ScenicStage)},
 * giving the user {@link ScenicStage}, that has the added multi page functionality.
 * </p>
 * Mostly for quality of life, makes the creation of the driver class simpler
 *
 * @see Application
 * @see Stage
 * @see ScenicStage
 **/
public abstract class ScenicApplication extends Application {
    /**
     * Driver function given by {@link Application}
     * <p>
     * Is NOT meant to be overridden, in doing so
     * {@link ScenicApplication#scenicStart(ScenicStage)} will not be called.
     * </p>
     *
     * @param stage A stage provided by {@link Application}
     **/
    @Override
    public void start(Stage stage) throws Exception {
        scenicStart((ScenicStage) (stage = new ScenicStage()));
    }

    /**
     * Entrypoint using a {@link ScenicStage}
     *
     * @param stage A provided {@link ScenicStage} to create a (presumably) multi page app on
     **/
    public abstract void scenicStart(ScenicStage stage) throws IOException;
}
