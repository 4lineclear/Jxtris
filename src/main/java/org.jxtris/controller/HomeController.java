package org.jxtris.controller;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import org.jxtris.framework.ScenicController;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController extends ScenicController implements Initializable {
    @FXML
    GridPane mainPanel;

    @FXML
    public void playClick() {
        setScene("Gamemode");
    }

    @FXML
    public void helpClick() {

    }

    @FXML
    public void settingsClick() {

    }

    @FXML
    public void controlsClick() {
        setScene("Controls");
    }

    private void initializeFontSizeManager() {
        mainPanel.sceneProperty().addListener((observableScene, oldScene, newScene) -> {
            // We need a scene to work on
            if (oldScene == null && newScene != null) {
                DoubleProperty fontSize = new SimpleDoubleProperty(0);
                fontSize.bind(newScene.widthProperty().add(newScene.heightProperty())
                        .divide(1280 + 720) // I know, it's a very rough approximation :)
                        .multiply(100)); // get a suitable value to put before the '%' symbol in the style
                mainPanel.styleProperty().bind(
                        Bindings.concat("-fx-font-size: ", fontSize.asString("%.0f")).concat("%;"));
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeFontSizeManager();
    }
}
