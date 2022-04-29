package main.java.framework;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Objects;

public class ScenicLoader {
    private static String FXML_FILE_PATH = "";
    private static Class<?> LOADER_CLASS = ScenicController.class;
    public final String fileName;
    private final Scene scene;
    private final ScenicController controller;

    public ScenicLoader(String fileName) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(LOADER_CLASS.getResource(FXML_FILE_PATH + fileName + ".fxml")));
        this.scene = new Scene(loader.load());
        this.controller = loader.getController();
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

    public void setStage(ScenicStage stage) {
        controller.setStage(stage);
    }
}
