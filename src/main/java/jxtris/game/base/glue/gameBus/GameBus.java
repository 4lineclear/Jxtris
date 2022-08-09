package jxtris.game.base.glue.gameBus;

import jxtris.game.base.glue.gameBus.components.*;
import jxtris.game.base.state.BaseGame;
import jxtris.game.base.state.GameState;
import jxtris.game.controls.Control;

public class GameBus {
    private long ARRTimer;
    private final Lockable leftRotationLock, rightRotationLock,  _180RotationLock;
    private final PiecePlacer piecePlacer;
    private final ScheduledTimer softDropTimer, gravityDropper;
    private final MoveTimer leftMoveTimer, rightMoveTimer;
    private final BaseGame game;
    public GameBus(BaseGame game) {
        this.game = game;

        final int das = 75;

        leftMoveTimer = new MoveTimer(das);
        rightMoveTimer = new MoveTimer(das);

        softDropTimer = new ScheduledTimer(1);
        gravityDropper = new ScheduledTimer(1000) {
            @Override
            public void increment(double increment) {
                value += increment;
            }
        };

        leftRotationLock = new GenericLockable();
        rightRotationLock = new GenericLockable();
        _180RotationLock = new GenericLockable();

        piecePlacer = new PiecePlacer(500);
    }
    public void increment(double elapsed){
        gravityDropper.increment(elapsed);
        if (gravityDropper.goalReached()) {
            gravityDropper.reset();
            game.move(0,1);
        }

        leftMoveTimer.increment(elapsed);
        rightMoveTimer.increment(elapsed);
        moveDAS(elapsed, leftMoveTimer, -1);
        moveDAS(elapsed, rightMoveTimer, 1);

        if(softDropTimer.scheduled()){
            softDropTimer.increment(elapsed);
            int moveAmount = (int)(elapsed/1);
            for (int i = 0; i < moveAmount; i++)
                game.move(0, 1);
            checkPlace(false);
        }
        piecePlacer.increment(elapsed);
        if(piecePlacer.goalReached() )
            placePiece();
        if(piecePlacer.forcePlace()){
            while (true)
                if (!game.move(0, 1)) break;

            placePiece();
        }


    }

    private void moveDAS(double elapsed, ScheduledTimer moveTimer, int direction) {
        if(!moveTimer.goalReached())
            return;

        if(!moveTimer.scheduled()) moveTimer.reset();
        int moveAmount = 0 == 0 ? 10: (int) (elapsed/0);
        for (int i = 0; i < moveAmount; i++)
            game.move(direction, 0);
        checkPlace(true);
    }

    public GameState getState(){
        return game.getState();
    }

    private void placePiece(){
        piecePlacer.reset();
        game.placeMino();
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
    private void checkPlace(boolean softInterrupt){
        if (softInterrupt)
            piecePlacer.softInterrupt();
        if(game.canMove(0,1)){
            if(piecePlacer.scheduled())
                piecePlacer.hardInterrupt();
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
