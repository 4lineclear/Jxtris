package jxtris.game.base.glue;

import javafx.scene.Node;
import jxtris.game.base.controls.Control;
import jxtris.game.base.state.BaseGame;
import jxtris.game.base.state.State;

public class GameBus {
    private final BaseGame game;
    private long nextDrop;

    public GameBus(BaseGame game) {
        this.game = game;
        this.nextDrop = 0;
    }

    public void increment(long elapsed){
        nextDrop += elapsed;
        if(nextDrop > 1000){
            game.move(0,1);
            nextDrop = 0;
        }
    }
    /**
     * Called when key is pressed
     * Calls the game to change it's state appropriately
     * @param control What the user has pressed
     * @see jxtris.game.base.controls.KeyPoller#pollNode(Node)
     */
    public void catchKey(Control control) {
        switch (control){
            case MOVE_LEFT -> {
                game.move(1,0);
            }
            case MOVE_RIGHT -> {
                game.move(-1,0);
            }
            case ROTATE_LEFT -> {
                game.rotate(-1);
            }
            case ROTATE_RIGHT -> {
                game.rotate(1);
            }
            case SOFT_DROP -> {
                game.move(0,1);
            }
            case HARD_DROP -> {
                game.move(0,20);
            }
            case ROTATE_180 -> {
                game.rotate(2);
            }
            case HOLD -> {
                game.hold();
            }
            case RESTART -> {
                throw new RuntimeException("Restarting not implemented yet!");
            }
            case ESCAPE -> {
                throw new RuntimeException("Escaping not implemented yet");
            }
        }
    }

    /**
     * Called when key is released \
     * Calls the game to change it's state appropriately
     * @param control What the user has pressed
     * @see jxtris.game.base.controls.KeyPoller#pollNode(Node)
     */
    public void throwKey(Control control) {
        switch (control){
            case MOVE_LEFT -> {
            }
            case MOVE_RIGHT -> {
            }
            case ROTATE_LEFT -> {
            }
            case ROTATE_RIGHT -> {
            }
            case SOFT_DROP -> {
            }
            case HARD_DROP -> {
            }
            case ROTATE_180 -> {
            }
            case HOLD -> {
            }
            case RESTART -> {
            }
            case ESCAPE -> {
            }
        }
    }
}
