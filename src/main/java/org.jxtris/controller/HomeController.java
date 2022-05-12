package org.jxtris.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import org.jxtris.framework.ScenicController;

public class HomeController extends ScenicController {
    @FXML
    GridPane mainPanel;

    @FXML
    public void playClick() {
        setScene("Gamemode");
    }

    @FXML
    public void helpClick() {
        setScene("Help");
    }

    @FXML
    public void settingsClick() {
        setScene("Settings");
    }

    @FXML
    public void controlsClick() {
        setScene("Controls");
    }

//    Makes page resizable
//    private void initializeFontSizeManager() {
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
//    }

}
