package jxtris.game.base.glue;

import jxtris.game.base.state.BaseGame;
import jxtris.game.base.state.GameState;
import jxtris.game.controls.Control;

public class GameBus {
    long drop, leftDas, rightDas;
    private final BaseGame game;
    public GameBus(BaseGame game) {
        this.game = game;
    }
    public void increment(long elapsed){
        drop += elapsed;
        if (drop > 1000) {
            drop = 0;
            if(!game.move(0, 1))
                game.placeMino();
        }
    }
    public GameState getState(){
        return game.getState();
    }

    public void throwKey(Control control) {
        if (control == null)
            return;

        switch (control){
            case MOVE_LEFT -> {
                game.move(-1,0);
            }
            case MOVE_RIGHT -> {
                game.move(1,0);
            }
            case ROTATE_LEFT ->
                game.rotate(-1);
            case ROTATE_RIGHT ->
                    game.rotate(1);
            case SOFT_DROP -> {
                game.move(0,1);
            }
            case HARD_DROP -> {
                while (true)
                    if (!game.move(0, 1)) break;

                game.placeMino();
            }
            case ROTATE_180 ->
                    game.rotate(2);
            case HOLD -> {
            }
            case RESTART -> {
            }
            case ESCAPE -> {
            }
        }
    }

    public void catchKey(Control control) {
        if (control == null)
            return;
    }
}
