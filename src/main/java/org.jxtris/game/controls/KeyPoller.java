package org.jxtris.game.controls;

import javafx.scene.Node;
import javafx.scene.input.KeyCode;

import java.util.HashSet;
import java.util.Set;

public class KeyPoller {
    private static final Set<KeyCode> keysDown = new HashSet<>();
    private static Node node;
    private static final KeyPoller instance = new KeyPoller();

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

    private void clearKeys() {
        keysDown.clear();
    }

    private void removeKeyHandlers() {
        if (node != null) {
            node.setOnKeyPressed(null);
            node.setOnKeyReleased(null);
        }
    }

    private void setNode(Node node) {
        KeyPoller.node = node;
        KeyPoller.node.setOnKeyPressed(keyEvent -> {
            keysDown.add(keyEvent.getCode());
        });
        KeyPoller.node.setOnKeyReleased(keyEvent -> {
            keysDown.remove(keyEvent.getCode());
        });
    }

    public boolean isDown(KeyCode keyCode) {
        return keysDown.contains(keyCode);
    }
}
