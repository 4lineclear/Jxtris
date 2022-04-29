package main.java.framework;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Objects;
//TODO: DOCUMENT ALL OF THIS ITS VERY CONFUSING
//TODO: Create working Application subclass that exposes a working start(ScenicStage)
public abstract class ScenicController {

    private static String FXML_FILE_PATH = "";
    private static Class<?> LOADER_CLASS = ScenicController.class;
    public final String fileName;
    private final Scene scene;
    private ScenicStage stage;

    public ScenicController(String fileName) throws IOException {
        this.scene = new Scene(FXMLLoader.load(Objects.requireNonNull(LOADER_CLASS.getResource(FXML_FILE_PATH + fileName + ".fxml"))));
        this.fileName = fileName;
    }

    public static void setFxmlFilePath(String path) {
        FXML_FILE_PATH = path;
    }

    public static void setLoaderClass(Class<?> loaderClass) {
        LOADER_CLASS = loaderClass;
    }

    public Scene getScene() {
        return this.scene;
    }

    public void setScene(String fileName) {
        this.stage.setScene(fileName);
    }

    public void setStage(ScenicStage stage) {
        this.stage = stage;
    }
}
