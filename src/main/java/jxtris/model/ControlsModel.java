package jxtris.model;

import javafx.beans.property.StringProperty;
import javafx.scene.input.KeyCode;
import jxtris.game.base.controls.Control;
import jxtris.game.base.controls.KeyPoller;
import jxtris.readers.PropertiesReader;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Properties;

public class ControlsModel{

    private final Control[] controls;
    private final PropertiesReader properties;
    private StringProperty[] boundControls;
    private final String[] defaults = {"LEFT", "RIGHT", "Z", "X", "DOWN", "SPACE", "UP", "C", "R", "ESCAPE"};
    public ControlsModel() throws IOException {
        controls = Control.values();
        properties = new PropertiesReader("controls.properties");
    }
    public void save() throws IOException {
        for (int i = 0; i < boundControls.length; i++) {
            properties.setProperty(controls[i].toString(), KeyCode.valueOf(boundControls[i].getValue()).toString());
            controls[i].keyCode = KeyCode.getKeyCode(boundControls[i].getValue());
            KeyPoller.getInstance().setKey(controls[i]);
        }
        properties.store("Game Controls");

    }
    public void load(StringProperty[] boundControls){
        for (int i = 0; i < boundControls.length; i++) {
            boundControls[i].setValue(properties.getProperty(controls[i].toString()));
            controls[i].keyCode = KeyCode.getKeyCode(boundControls[i].getValue());
            KeyPoller.getInstance().addKey(controls[i]);
        }
        this.boundControls = boundControls;
    }
    public void setDefault() throws IOException {
        for (int i = 0; i < boundControls.length; i++)
            boundControls[i].setValue(defaults[i]);
        save();
    }
}
