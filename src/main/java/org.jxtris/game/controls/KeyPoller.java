package org.jxtris.game.controls;

import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import org.jxtris.game.base.Game;

import java.util.HashMap;
import java.util.Map;

public class KeyPoller {
    private final Map<KeyCode, Control> keys = new HashMap<>();
    private static final KeyPoller instance = new KeyPoller();
    private Node node;
    private Game game;

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
    public void pollGame(Game game){
        this.game = game;
    }
    public void addKey(Control control){
        this.keys.put(control.keyCode, control);
    }
    public void setKey(Control control){
        this.keys.remove(control.keyCode);
        addKey(control);
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
            game.throwInput(keys.get(keyEvent.getCode()));
        });
        this.node.setOnKeyReleased(keyEvent -> {
            game.catchInput(keys.get(keyEvent.getCode()));
        });
    }

}
