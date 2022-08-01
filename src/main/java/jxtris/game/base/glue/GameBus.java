package jxtris.game.base.glue;

import jxtris.game.base.state.BaseGame;
import jxtris.game.base.state.GameState;
import jxtris.game.controls.Control;

public class GameBus {
    private final long softDrop,ARR;
    private long dropTime, placeTime, placeCancelCounter, ARRTimer;
    private final Lockable leftRotationLock, rightRotationLock,  _180RotationLock;
    private boolean placeCancelScheduled;
    private final ScheduledTimer softDropTimer;
    private final MoveTimer leftMoveTimer, rightMoveTimer;
    private final BaseGame game;
    public GameBus(BaseGame game) {
        this.game = game;
        final int das = 85;
        ARR = 0;
        softDrop = 1;
        leftMoveTimer = new MoveTimer(das);
        rightMoveTimer = new MoveTimer(das);
        softDropTimer = new ScheduledTimer(1);
        leftRotationLock = new GenericLockable();
        rightRotationLock = new GenericLockable();
        _180RotationLock = new GenericLockable();

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
                if(placeCancelScheduled) {
                    placeCancelCounter++;
                    placeTime = placeCancelCounter*50;
                    placeCancelScheduled = false;
                }

                else
                    placePiece();
            }

        } else game.move(0, -1);

        leftMoveTimer.increment(elapsed);
        rightMoveTimer.increment(elapsed);

        if(!moveDAS(elapsed, leftMoveTimer, -1))
            moveDAS(elapsed, rightMoveTimer, 1);

        if(softDropTimer.scheduled()){
            int moveAmount = (int)(elapsed/softDrop);
            System.out.println(moveAmount);
            for (int i = 0; i < moveAmount; i++)
                game.move(0, 1);
        }
    }

    private boolean moveDAS(long elapsed, ScheduledTimer moveTimer, int direction) {
        if(!moveTimer.goalReached())
            return false;

        if(!moveTimer.scheduled()) moveTimer.reset();
        int moveAmount = ARR == 0 ? 10: (int) (elapsed/ARR);
        for (int i = 0; i < moveAmount; i++)
            game.move(direction, 0);

        return true;
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
    private void rotate(int direction, Lockable lockable){
        if (lockable.locked()) return;
        game.rotate(direction);
        lockable.lock();
        placeCancelScheduled = true;
    }
    private void move(int direction, ScheduledTimer moveTimer){
        if(moveTimer.scheduled()) return;
        game.move(direction, 0);
        moveTimer.schedule();
        placeCancelScheduled = true;
    }


    public void throwKey(Control control) {
        if (control == null)
            return;

        switch (control){
            case MOVE_LEFT -> {
                move(-1, leftMoveTimer);
                rightMoveTimer.reset();
            }
            case MOVE_RIGHT -> {
                move(1, rightMoveTimer);
                leftMoveTimer.reset();
            }
            case ROTATE_LEFT -> {
                rotate(1, leftRotationLock);
            }
            case ROTATE_RIGHT -> {
                rotate(-1, rightRotationLock);
            }
            case SOFT_DROP -> {
                softDropTimer.schedule();
            }
            case HARD_DROP -> {
                while (true)
                    if (!game.move(0, 1)) break;

                placePiece();
            }
            case ROTATE_180 -> {
                rotate(2, _180RotationLock);
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
                leftMoveTimer.reset();
            }
            case MOVE_RIGHT -> {
                rightMoveTimer.reset();
            }
            case ROTATE_LEFT ->{
                leftRotationLock.reset();
            }
            case ROTATE_RIGHT -> {
                rightRotationLock.reset();
            }
            case SOFT_DROP -> {
                softDropTimer.reset();
            }
            case HARD_DROP -> {
            }
            case ROTATE_180 -> {
                _180RotationLock.reset();
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
