package jxtris.game.base.glue;

import jxtris.game.base.state.BaseGame;
import jxtris.game.base.state.GameState;
import jxtris.game.controls.Control;

public class GameBus {
    private final long leftDAS, rightDAS, ARR;
    private long dropTime, placeTime, placeCancelCounter, leftMoveTimer, rightMoveTimer, ARRTimer;
    private boolean leftRotationLock, rightRotationLock, _180RotationLock ,leftMoveLock, rightMoveLock, placeCancelScheduled;
    private final BaseGame game;
    public GameBus(BaseGame game) {
        this.game = game;
        leftDAS = 100;
        rightDAS = 100;
        ARR = 10;
    }
    public void increment(long elapsed){
        dropTime += elapsed;
        if (dropTime > 1000) {
            dropTime = 0;
            game.move(0,1);
        }
        if(!game.move(0, 1)) {
            placeTime += elapsed;
            if (placeCancelScheduled) {
                placeTime -= elapsed;
                placeTime += 10;
            }
            if (placeTime > 500){
                if(!placeCancelScheduled)
                    placePiece();

                else {
                    placeCancelCounter++;
                    placeTime = placeCancelCounter*50;
                    placeCancelScheduled = false;
                }
            }

        } else game.move(0, -1);

    }
    public GameState getState(){
        return game.getState();
    }

    private void placePiece(){
        placeTime = 0;
        placeCancelCounter = 0;
        placeCancelScheduled = false;
        game.placeMino();
    }

    public void throwKey(Control control) {
        if (control == null)
            return;

        switch (control){
            case MOVE_LEFT -> {
                if(leftMoveLock) {
                    return;
                }
                game.move(-1,0);
                placeCancelScheduled = true;
                leftMoveLock = true;
            }
            case MOVE_RIGHT -> {
                if(rightMoveLock) {
                    return;
                }
                game.move(1,0);
                placeCancelScheduled = true;
                rightMoveLock = true;
            }
            case ROTATE_LEFT -> {
                if (leftRotationLock) return;
                game.rotate(1);
                leftRotationLock = true;
                placeCancelScheduled = true;
            }
            case ROTATE_RIGHT -> {
                if (rightRotationLock) return;
                game.rotate(-1);
                rightRotationLock = true;
                placeCancelScheduled = true;
            }
            case SOFT_DROP -> {
                game.move(0,1);
            }
            case HARD_DROP -> {
                while (true)
                    if (!game.move(0, 1)) break;

                placePiece();
            }
            case ROTATE_180 -> {
                if(_180RotationLock) return;
                game.rotate(2);
                _180RotationLock = true;
                placeCancelScheduled = true;
            }
            case HOLD -> {
                game.hold();
                placeCancelScheduled = true;
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
        switch (control){
            case MOVE_LEFT -> {
                leftMoveLock = false;
            }
            case MOVE_RIGHT -> {
                rightMoveLock = false;
            }
            case ROTATE_LEFT ->{
                leftRotationLock = false;
            }
            case ROTATE_RIGHT -> {
                rightRotationLock = false;
            }
            case SOFT_DROP -> {
            }
            case HARD_DROP -> {
            }
            case ROTATE_180 -> {
                _180RotationLock = false;
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
