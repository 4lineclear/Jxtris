package jxtris.model;

import javafx.beans.property.StringProperty;
import javafx.scene.input.KeyCode;
import jxtris.game.controls.Control;
import jxtris.game.controls.KeyPoller;
import jxtris.readers.PropertiesReader;

import java.io.*;

public class ControlsModel{

    private final Control[] controls;
    private final PropertiesReader properties;
    private StringProperty[] boundControls;
    private final String[] defaults = {"Left", "Right", "Z", "X", "Down", "Space", "Up", "C", "R", "Esc"};
    public ControlsModel() throws IOException {
        controls = Control.values();
        properties = new PropertiesReader("controls.properties");
    }
    public void save() throws IOException {
        for (int i = 0; i < boundControls.length; i++) {
            properties.setProperty(controls[i].toString(), boundControls[i].getValue());
            KeyPoller.getInstance().setKey(controls[i], KeyCode.getKeyCode(boundControls[i].getValue()));
        }
        properties.store("Game Controls");
    }
    public void load(StringProperty[] boundControls){
        for (int i = 0; i < boundControls.length; i++) {
            boundControls[i].setValue(properties.getProperty(controls[i].toString()));
            KeyPoller.getInstance().addKey(controls[i], KeyCode.getKeyCode(boundControls[i].getValue()));
        }
        this.boundControls = boundControls;
    }
    public void setDefault() throws IOException {
        for (int i = 0; i < boundControls.length; i++) {
            boundControls[i].setValue(defaults[i]);
        }
        save();
    }
}
