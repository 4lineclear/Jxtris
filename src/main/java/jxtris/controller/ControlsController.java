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
import java.util.HashMap;

public class ControlsController extends PagicController {
    @FXML
    TextField moveLeft, moveRight, rotateLeft, rotateRight, softDrop, hardDrop, rotate180, hold, restart, escape;
    StringProperty[] controlProperties;
    private final ControlsModel controlsModel;
    @FXML
    Button save;

    public ControlsController() throws IOException {
        this.controlsModel = new ControlsModel();
    }

    public void backClick() {
        setScene("Home");
    }

    public void saveClick() throws IOException {
        controlsModel.save();
        save.setDisable(true);
    }

    public void defaultClick() throws IOException {
        controlsModel.setDefault();
        save.setDisable(true);
    }

    public void setControl(KeyEvent keyEvent) {
        setControl(keyEvent.getCode(), (TextField) keyEvent.getSource());
    }

    public void setControl(KeyCode keyCode, TextField textField) {
        textField.setText(keyCode.getName());
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
