package main.java.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.Hashtable;
import java.util.ResourceBundle;

public class HomeController extends BaseController implements Initializable {
    @FXML
    GridPane mainPanel;
    Scene gamemode;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeFontSizeManager();
    }

    @Override
    protected void setScenes(Hashtable<String, SceneObject> scenes) {
        gamemode = scenes.get("Gamemode.fxml").scene;
    }

    private void initializeFontSizeManager() {

//        mainPanel.sceneProperty().addListener((observableScene, oldScene, newScene) -> {
//            // We need a scene to work on
//            if (oldScene == null && newScene != null) {
//                DoubleProperty fontSize = new SimpleDoubleProperty(0);
//                fontSize.bind(newScene.widthProperty().add(newScene.heightProperty())
//                        .divide(1280 + 720) // I know, it's a very rough approximation :)
//                        .multiply(100)); // get a suitable value to put before the '%' symbol in the style
//                mainPanel.styleProperty().bind(
//                        Bindings.concat("-fx-font-size: ", fontSize.asString("%.0f")).concat("%;"));
//            }
//        });
    }

    @FXML
    public void playClick() {
        stage.setScene(gamemode);
    }

    @FXML
    public void helpClick() {

    }

    @FXML
    public void settingsClick() {

    }

    @FXML
    public void controlsClick() {

    }
}
