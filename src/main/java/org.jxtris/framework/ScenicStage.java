package org.jxtris.framework;

import javafx.stage.Stage;

import java.util.HashMap;

/**
 * A subclass of {@link Stage} that streamlines multi page development
 **/
public class ScenicStage extends Stage {
    /**
     * A {@link HashMap} containing saved {@link ScenicLoader} to switch the current scene to
     * <p>
     * Keys should be the name of the FXML file that is trying to be loaded to the screen.
     * </p>
     **/
    private final HashMap<String, ScenicLoader> scenes;

    /**
     * Creates a new instance with an empty {@link HashMap} of {@link ScenicLoader}
     **/
    public ScenicStage() {
        this.scenes = new HashMap<>();
    }

    /**
     * Add a {@link ScenicLoader} to the window to be used later
     * <p>
     * Is used in conjunction with {@link ScenicStage#setScene(String)}
     * to make switching the scene simple
     * </p>
     * Calls {@link ScenicLoader#setStage(ScenicStage)} to inject itself into the file
     * to be used later for page switching
     *
     * @param scene The {@link ScenicLoader} to add
     * @see ScenicStage#setScene(String)
     * @see ScenicLoader#setStage(ScenicStage)
     **/
    public void addScene(ScenicLoader scene) {
        this.scenes.put(scene.fileName, scene);
        scene.setStage(this);
    }

    /**
     * Set the current scene presented to the screen
     * <p>
     * Is used in conjunction with {@link ScenicStage#addScene(ScenicLoader)}
     * to make switching the scene simple. <br>
     * For example, if trying to switch
     * to a scene with an FXML file called "Home.fxml", if that file was previously saved,
     * this can be called: {@code scenicStage.setScene("Home");}
     * </p>
     * Is meant to be called from a {@link ScenicLoader}
     *
     * @param key The name of the FXML file you're trying to load into the screen
     * @see ScenicStage#addScene(ScenicLoader)
     * @see ScenicLoader
     **/
    public void setScene(String key) {
        this.setScene(this.scenes.get(key).getScene());
    }
}
