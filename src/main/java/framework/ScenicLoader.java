package main.java.framework;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Objects;

/**
 * Loads an FXML file into a Scene
 **/
public class ScenicLoader {
    /**
     * The directory the FXML files to load should be in
     * <p>
     *     Something like: /resources/fxml
     * </p>
     * @see ScenicLoader#setFxmlFilePath(String)
     **/
    private static String FXML_FILE_PATH = "";
    /**
     * The class to load from, should be the driver class
     * <p>
     *     URLs are loaded using {@link Class#getResource(String)},
     *     so specifying the class to load from is important
     * </p>
     * @see ScenicLoader#setLoaderClass(Class)
     **/
    private static Class<?> LOADER_CLASS = ScenicController.class;
    /**
     * The name of the file saved
     * <p>
     *     For example, if the FXML file is /resources/fxml/Home.fxml,
     *     the filename would be "Home"
     * </p>
     **/
    public final String fileName;
    /**
     * The saved scene that is loaded with the {@link ScenicLoader#fileName}
     **/
    private final Scene scene;
    /**
     * Controller of the loaded scene
     **/
    private final ScenicController controller;

    /**
     * Create a {@link ScenicLoader} instance with a specified filename
     * <p>
     *     Loads a scene, saves its controller and the associated filename
     * </p>
     * @param fileName The name of the FXML file to load
     **/
    public ScenicLoader(String fileName) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(LOADER_CLASS.getResource(FXML_FILE_PATH + fileName + ".fxml")));
        this.scene = new Scene(loader.load());
        this.controller = loader.getController();
        this.fileName = fileName;
    }

    /**
     * Set the directory of the FXML files to load
     * <p>
     *     Is used by {@link Class#getResource(String)} specified by {@link ScenicLoader#setLoaderClass(Class)}
     * </p>
     * @param path Path to set
     **/
    public static void setFxmlFilePath(String path) {
        FXML_FILE_PATH = path;
    }

    /**
     * Set the class to load from
     * <p>
     *     Is used to call {@link Class#getResource(String)}, using a directory and filename previously specified
     * </p>
     * @param loaderClass Class to load resources from
     **/
    public static void setLoaderClass(Class<?> loaderClass) {
        LOADER_CLASS = loaderClass;
    }
    /**
     * The previously loaded scene
     * @return Scene created when the {@link ScenicLoader} instance was created
     **/
    public Scene getScene() {
        return this.scene;
    }

    /**
     * Sets the window that the scene will be displayed on
     **/
    public void setStage(ScenicStage stage) {
        controller.setStage(stage);
    }
}
