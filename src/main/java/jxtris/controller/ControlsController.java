package jxtris.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import jxtris.model.ControlsModel;
import jxtris.pagicFX.PagicController;

import java.io.IOException;
import java.net.URISyntaxException;

public class ControlsController extends PagicController {

    @FXML
    TextField moveLeft, moveRight, rotateLeft, rotateRight, softDrop, hardDrop, rotate180, hold, restart, escape;
    StringProperty[] controlProperties;
    private final ControlsModel controlsModel;
    @FXML
    Button save;

    public ControlsController() throws IOException, URISyntaxException {
        this.controlsModel = new ControlsModel();
    }

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

    public void saveClick() throws IOException {
        controlsModel.save();
        save.setDisable(true);
    }

    public void defaultClick() throws IOException {
        controlsModel.setDefault();
        save.setDisable(true);
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

    @FXML
    public void initialize(){
        TextField[] controlFields = new TextField[]{moveLeft, moveRight, rotateLeft, rotateRight, softDrop, hardDrop, rotate180, hold, restart, escape};
        controlProperties = new SimpleStringProperty[controlFields.length];
        for (int i = 0; i < controlFields.length; i++) {
            controlProperties[i] = new SimpleStringProperty();
            controlProperties[i].bindBidirectional(controlFields[i].textProperty());
        }
        setupControls();
    }

    private void setupControls() {
        controlsModel.load(controlProperties);
    }
}
