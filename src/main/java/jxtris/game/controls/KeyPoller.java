package jxtris.game.controls;

import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import jxtris.game.base.glue.GameBus;

import java.util.HashMap;
import java.util.Map;

public class KeyPoller {
    private static final KeyPoller instance = new KeyPoller();
    private final Map<KeyCode, Control> keys = new HashMap<>();
    private GameBus gameBus;

    private KeyPoller() {
    }

    public static KeyPoller getInstance() {
        return instance;
    }

    public void pollNode(Node node) {
        node.setOnKeyPressed(keyEvent ->
                gameBus.throwKey(keys.get(keyEvent.getCode()))
        );
        node.setOnKeyReleased(keyEvent ->
                gameBus.catchKey(keys.get(keyEvent.getCode()))
        );
    }

    public void setGameBus(GameBus gameBus) {
        this.gameBus = gameBus;
    }

    public void addKey(Control control, KeyCode code) {
        this.keys.put(code, control);
    }

    public void setKey(Control control, KeyCode code) {
        this.keys.remove(code);
        this.keys.put(code, control);
    }


}