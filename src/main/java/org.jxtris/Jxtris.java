package org.jxtris;

import javafx.application.Application;
import javafx.stage.Stage;
import org.jxtris.framework.ScenicApplication;
import org.jxtris.framework.ScenicLoader;
import org.jxtris.framework.ScenicStage;

import java.io.IOException;

/**
 * Driver class, contains the startup of JavaFX
 * <p>
 * Extends {@link ScenicApplication} instead of {@link Application}
 * since this is a multi page app
 * </p>
 **/
public class Jxtris extends ScenicApplication {

    /**
     * Driver function, launches {@link Jxtris#start(Stage)} using {@link Application#launch(String...)}
     **/
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Method given by JavaFX {@link ScenicApplication}
     * <p>
     * Drives JavaFX code
     * </p>
     *
     * @param stage The stage given by {@link ScenicStage}
     * @throws IOException most likely file is not found
     **/
    @Override
    public void scenicStart(ScenicStage stage) throws IOException {
        ScenicLoader.setFxmlFilePath("/org.jxtris/fxml/");
        ScenicLoader.setLoaderClass(this.getClass());
        String[] pages = {"Home", "Gamemode", "Game", "Controls"};
        for (String page : pages) {
            ScenicLoader scenicLoader = new ScenicLoader(page);
            stage.addScene(scenicLoader);
        }
        stage.setScene("Home");
        stage.setTitle("Jxtris");
        stage.setResizable(false);
        stage.show();
    }
}
