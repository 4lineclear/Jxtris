package org.jxtris.model;

import javafx.beans.property.StringProperty;
import javafx.scene.input.KeyCode;
import org.jxtris.game.controls.Control;
import org.jxtris.game.controls.KeyPoller;
import org.jxtris.game.controls.KeyProperty;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Properties;

public class ControlsModel{

    private final Control[] controls = Control.values();
    private final Properties controlsProperties = new Properties();
    private final File propertiesFile;
    private StringProperty[] boundControls;
    private final String[] defaults = {"LEFT", "RIGHT", "Z", "X", "DOWN", "SPACE", "UP", "C", "R", "ESCAPE"};
    public ControlsModel() throws IOException, URISyntaxException {
        propertiesFile = new File(Objects.requireNonNull(this.getClass().getResource("/properties/controls.properties")).toURI());
        controlsProperties.load(new FileReader(propertiesFile));
    }
    public void save() throws IOException {
        for (int i = 0; i < boundControls.length; i++)
            controlsProperties.setProperty(controls[i].toString(), KeyCode.valueOf(boundControls[i].getValue()).toString());
        controlsProperties.store(new FileWriter(propertiesFile), "Game Controls");
        KeyCode[] keyCodes = new KeyCode[boundControls.length];
        for (int i = 0; i < keyCodes.length; i++) {
            keyCodes[i] = KeyCode.valueOf(boundControls[i].getValue());
        }
        KeyProperty[] keyProperties = new KeyProperty[boundControls.length];
        for (int i = 0; i < keyProperties.length; i++) {
            keyProperties[i] = new KeyProperty() {
                @Override
                protected void throwKey() {

                }

                @Override
                protected void catchKey() {

                }
            };
        }
        KeyPoller.getInstance().setKeys(keyCodes, keyProperties);
    }
    public void load(StringProperty[] boundControls){
        for (int i = 0; i < boundControls.length; i++)
            boundControls[i].setValue(controlsProperties.getProperty(controls[i].toString()));
        this.boundControls = boundControls;
    }
    public void setDefault() throws IOException {
        for (int i = 0; i < boundControls.length; i++)
            boundControls[i].setValue(defaults[i]);
        save();
    }
}
