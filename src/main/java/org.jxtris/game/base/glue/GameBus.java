package org.jxtris.game.base.glue;

import org.jxtris.game.base.controls.Control;
import org.jxtris.game.base.state.BaseGame;

import java.util.HashMap;
import java.util.Map;

public class GameBus {
    private final BaseGame game;

    public GameBus(BaseGame game) {
        this.game = game;
    }

    public void catchKey(Control control) {

    }

    public void throwKey(Control control) {

    }
}
