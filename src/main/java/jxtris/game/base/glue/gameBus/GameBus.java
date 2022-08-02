package jxtris.game.base.glue.gameBus;

import jxtris.game.base.glue.gameBus.components.*;
import jxtris.game.base.state.BaseGame;
import jxtris.game.base.state.GameState;
import jxtris.game.controls.Control;

public class GameBus {
    private final long softDrop,ARR;
    private long gravity, dropTime, ARRTimer;
    private final Lockable leftRotationLock, rightRotationLock,  _180RotationLock;
    private final ScheduledTimer softDropTimer;
    private final MoveTimer leftMoveTimer, rightMoveTimer;
    private final PiecePlacer piecePlacer;
    private final BaseGame game;
    public GameBus(BaseGame game) {
        this.game = game;

        final int das = 75;
        ARR = 0;
        softDrop = 1;
        gravity = 1000;

        leftMoveTimer = new MoveTimer(das);
        rightMoveTimer = new MoveTimer(das);

        softDropTimer = new ScheduledTimer(1);

        leftRotationLock = new GenericLockable();
        rightRotationLock = new GenericLockable();
        _180RotationLock = new GenericLockable();

        piecePlacer = new PiecePlacer(500);
    }
    public void increment(long elapsed){
        dropTime += elapsed;
        if (dropTime > gravity) {
            dropTime = 0;
            game.move(0,1);
            checkPlace(false);
        }

        leftMoveTimer.increment(elapsed);
        rightMoveTimer.increment(elapsed);
        moveDAS(elapsed, leftMoveTimer, -1);
        moveDAS(elapsed, rightMoveTimer, 1);

        if(softDropTimer.scheduled()){
            int moveAmount = (int)(elapsed/softDrop);
            for (int i = 0; i < moveAmount; i++)
                game.move(0, 1);
            checkPlace(false);
        }
        piecePlacer.increment(elapsed);
        if (piecePlacer.goalReached()) {
            if (piecePlacer.applyInterrupt()) {
                if (!game.move(0, 1))
                    placePiece();
                else
                    game.move(0, -1);

            }
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
        piecePlacer.hardReset();
        game.placeMino();
        gravity = 1000;
    }
    private void rotate(int direction, Lockable lockable){
        if (lockable.locked()) return;
        game.rotate(direction);
        lockable.lock();
        checkPlace(true);
    }
    private void move(int direction, ScheduledTimer moveTimer){
        if(moveTimer.scheduled()) return;
        game.move(direction, 0);
        moveTimer.schedule();
        checkPlace(true);
    }
    private void checkPlace(boolean interrupt){
        if (interrupt) {
            piecePlacer.interrupt();
            if(piecePlacer.scheduled())gravity = piecePlacer.applyGravity();
        }
        if (game.move(0, 1)) {
            game.move(0,-1);
            piecePlacer.reset();
            return;
        }

        piecePlacer.schedule();
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
