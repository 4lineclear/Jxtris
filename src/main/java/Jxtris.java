package main.java;

import javafx.application.Application;
import javafx.stage.Stage;
import main.java.framework.ScenicApplication;
import main.java.framework.ScenicLoader;
import main.java.framework.ScenicStage;

import java.io.IOException;

/**
 * Driver class, contains the startup of JavaFX and the creation of any MVC components
 **/
public class Jxtris extends ScenicApplication {

    /**
     * Driver function, launches {@link Jxtris#start(Stage)}
     **/
    public static void main(String[] args) {
        launch(args);
//        IGame game = new Game();
//        System.exit(0);
    }

    /**
     * Method given by JavaFX {@link Application}
     * <p>
     * Also creates MVC components
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
