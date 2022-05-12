package org.jxtris.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.jxtris.framework.ScenicController;
import org.jxtris.game.controls.Control;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;
import java.util.ResourceBundle;

public class ControlsController extends ScenicController implements Initializable {

    @FXML
    TextField moveLeft, moveRight, rotateLeft, rotateRight, softDrop, hardDrop, rotate180, hold, restart, escape;

    @FXML
    Button save;

    TextField[] controlFields;
    Control[] controls = Control.values();
    Properties controlsProperties = new Properties();
    File propertiesFile;

    public void backClick() {
        setScene("Home");
    }

    public void moveLeftChanged(KeyEvent keyEvent) {
        setControl(keyEvent, moveLeft);
    }

    public void moveRightChanged(KeyEvent keyEvent) {
        setControl(keyEvent, moveRight);
    }

    public void rotateLeftChanged(KeyEvent keyEvent) {
        setControl(keyEvent, rotateLeft);
    }

    public void rotateRightChanged(KeyEvent keyEvent) {
        setControl(keyEvent, rotateRight);
    }

    public void softDropChanged(KeyEvent keyEvent) {
        setControl(keyEvent, softDrop);
    }

    public void hardDropChanged(KeyEvent keyEvent) {
        setControl(keyEvent, hardDrop);
    }

    public void rotate180Changed(KeyEvent keyEvent) {
        setControl(keyEvent, rotate180);
    }

    public void holdChanged(KeyEvent keyEvent) {
        setControl(keyEvent, hold);
    }

    public void restartChanged(KeyEvent keyEvent) {
        setControl(keyEvent, restart);
    }

    public void escapeChanged(KeyEvent keyEvent) {
        setControl(keyEvent, escape);
    }

    public void saveClick(MouseEvent mouseEvent) {
        for (int i = 0; i < controlFields.length; i++)
            controlsProperties.setProperty(controls[i].toString(), KeyCode.valueOf(controlFields[i].getText()).toString());
        try {
            controlsProperties.store(new FileWriter(propertiesFile), "Game Controls");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        save.setDisable(true);
    }

    public void defaultClick(MouseEvent mouseEvent) {
        String[] defaults = {"LEFT", "RIGHT", "Z", "X", "DOWN", "SPACE", "UP", "C", "R", "ESCAPE"};
        for (int i = 0; i < controlFields.length; i++)
            setControl(KeyCode.valueOf(defaults[i]), controlFields[i]);
        saveClick(mouseEvent);
    }

    public void setControl(KeyEvent keyEvent, TextField textField) {
        setControl(keyEvent.getCode(), textField);
    }

    public void setControl(KeyCode keyCode, TextField textField) {
        textField.setText(keyCode.toString());
        if (keyCode == KeyCode.TAB) {
            textField.requestFocus();
            textField.deselect();
        }
        save.setDisable(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.controlFields = new TextField[]{moveLeft, moveRight, rotateLeft, rotateRight, softDrop, hardDrop, rotate180, hold, restart, escape};
        try {
            setupControls();
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private void setupControls() throws IOException, URISyntaxException {
        propertiesFile = new File(Objects.requireNonNull(this.getClass().getResource("/properties/controls.properties")).toURI());
        controlsProperties.load(new FileReader(propertiesFile));
        for (int i = 0; i < controlFields.length; i++)
            controlFields[i].setText(controlsProperties.getProperty(controls[i].toString()));
    }
}
