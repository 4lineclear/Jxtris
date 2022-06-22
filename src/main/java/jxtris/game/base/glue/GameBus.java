package jxtris.game.base.glue;

import jxtris.game.base.controls.Control;
import jxtris.game.base.state.BaseGame;

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
