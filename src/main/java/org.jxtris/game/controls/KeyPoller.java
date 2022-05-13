package org.jxtris.game.controls;

import javafx.scene.Node;
import javafx.scene.input.KeyCode;

import java.util.HashMap;
import java.util.Map;

public class KeyPoller {
    private final Map<KeyCode, KeyProperty> keys = new HashMap<>();
    private static final KeyPoller instance = new KeyPoller();
    private Node node;

    private KeyPoller() {
    }

    public static KeyPoller getInstance() {
        return instance;
    }

    public void pollNode(Node node) {
        clearKeys();
        removeKeyHandlers();
        setNode(node);
    }
    public void setKeys(KeyCode[] keyCodes, KeyProperty[] keyProperties){
        for (int i = 0; i < keyCodes.length; i++) {
            this.keys.put(keyCodes[i], keyProperties[i]);
        }
    }

    private void clearKeys() {
        keys.clear();
    }

    private void removeKeyHandlers() {
        if (node != null) {
            node.setOnKeyPressed(null);
            node.setOnKeyReleased(null);
        }
    }

    private void setNode(Node node) {
        this.node = node;
        this.node.setOnKeyPressed(keyEvent -> {
            keys.get(keyEvent.getCode()).throwKey();
        });
        this.node.setOnKeyReleased(keyEvent -> {
            keys.get(keyEvent.getCode()).catchKey();
        });
    }

}
