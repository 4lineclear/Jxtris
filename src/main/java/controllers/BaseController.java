package main.java.controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Hashtable;

public abstract class BaseController {
    protected final ArrayList<Scene> scenes = new ArrayList<>();
    protected Stage stage;

    public void setup(Stage stage, Hashtable<String, SceneObject> scenes) {
        this.stage = stage;
        setScenes(scenes);
    }

    protected abstract void setScenes(Hashtable<String, SceneObject> scenes);
}
