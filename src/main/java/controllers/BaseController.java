package main.java.controllers;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public abstract class BaseController {
    protected Stage stage;
    protected final ArrayList<Scene> scenes = new ArrayList<>();
    public void setup(Stage stage, Hashtable<String, SceneObject> scenes){
        this.stage = stage;
        setScenes(scenes);
    }
    protected abstract void setScenes(Hashtable<String, SceneObject> scenes);
}
