package org.jxtris.game.base.controls;

import javafx.scene.Node;
import javafx.scene.input.KeyCode;


import java.util.HashMap;
import java.util.Map;

public class KeyPoller {
    private final Map<KeyCode, Control> keys = new HashMap<>();
    private static final KeyPoller instance = new KeyPoller();


    private KeyPoller() {
    }

    public static KeyPoller getInstance() {
        return instance;
    }

    public void pollNode(Node node) {
        node.setOnKeyPressed(keyEvent -> {

        });
        node.setOnKeyReleased(keyEvent -> {

        });
    }

    public void addKey(Control control){
        this.keys.put(control.keyCode, control);
        System.out.println(control);
    }
    public void setKey(Control control){
        this.keys.remove(control.keyCode);
        addKey(control);
    }


}
