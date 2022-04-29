package main.java.framework;

import javafx.stage.Stage;

import java.util.HashMap;

public class ScenicStage extends Stage {
    private final HashMap<String, ScenicLoader> scenes;

    public ScenicStage() {
        this.scenes = new HashMap<>();
    }

    public void addScene(ScenicLoader scene) {
        this.scenes.put(scene.fileName, scene);
        scene.setStage(this);
    }

    public void setScene(String key) {
        this.setScene(this.scenes.get(key).getScene());
    }
}
