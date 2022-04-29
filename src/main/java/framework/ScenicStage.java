package main.java.framework;

import javafx.stage.Stage;

import java.util.HashMap;

public class ScenicStage extends Stage {
    private final HashMap<String, ScenicController> scenes;

    public ScenicStage() {
        this.scenes = new HashMap<>();
    }

    public void addScene(ScenicController scene) {
        this.scenes.put(scene.fileName, scene);
        scene.setStage(this);
    }

    public void setScene(String key) {
        this.setScene(this.scenes.get(key).getScene());
    }
}
