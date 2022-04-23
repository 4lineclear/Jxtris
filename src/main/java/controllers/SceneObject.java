package main.java.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class SceneObject{
    public Parent sceneRoot;
    public BaseController controller;
    public Scene scene;
    public URL filePath;
    public SceneObject(URL filePath) {
        this.filePath = filePath;
    }
    public void loadAll() throws IOException {
        FXMLLoader loader = new FXMLLoader(filePath);
        this.scene = new Scene(loader.load());
        this.controller = loader.getController();
    }
    public String getFileName(){
        return new File(filePath.getPath()).getName();
    }
}
