package main.java;

import javafx.application.Application;
import javafx.stage.Stage;
import main.java.framework.ScenicApplication;
import main.java.framework.ScenicLoader;
import main.java.framework.ScenicStage;

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
//        IGame game = new Game();
//        System.exit(0);
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
        ScenicLoader.setFxmlFilePath("../resources/fxml/");
        ScenicLoader.setLoaderClass(this.getClass());
        String[] pages = {"Home", "Gamemode", "Game"};
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
