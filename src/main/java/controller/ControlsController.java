package main.java.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import main.java.framework.ScenicController;
import main.java.game.controller.Control;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class ControlsController extends ScenicController implements Initializable {
    private static HashMap<TextField, Control> controls;
    @FXML
    TextField moveLeft, moveRight, rotateLeft, rotateRight, softDrop, hardDrop, rotate180, hold, restart, escape;

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

    }

    public void defaultClick(MouseEvent mouseEvent) {
    }

    public void setControl(KeyEvent keyEvent, TextField textField) {
        textField.setText(keyEvent.getCode().toString());
        if (keyEvent.getCode() == KeyCode.TAB) {
            textField.requestFocus();
            textField.deselect();
        }
        controls.get(textField).keyCode = keyEvent.getCode();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controls = new HashMap<>();
        TextField[] textFields = { moveLeft, moveRight, rotateLeft, rotateRight, softDrop, hardDrop, rotate180, hold, restart, escape };
        Control[] allControls = Control.values();
        for (int i = 0; i < textFields.length; i++) {
            controls.put(textFields[i], allControls[i]);
        }
    }
}
