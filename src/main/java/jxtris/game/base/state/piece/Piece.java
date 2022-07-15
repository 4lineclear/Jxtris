package jxtris.game.base.state.piece;

import jxtris.game.base.state.Offsets;
import jxtris.game.base.state.Rotation;

import java.util.function.Predicate;

public class Piece {
    public final Mino mino;
    public final HeldMino heldMino;
    public final MinoQueue nextMinos;
    private final Offsets offsets;

    public Piece() {
        mino = new Mino();
        heldMino = new HeldMino();
        nextMinos = new MinoQueue();
        offsets = new Offsets();

        iterateMino();
    }
    public Mino iterateMino(){
        heldMino.currentMinoHeld = false;
        mino.type = nextMinos.next();
        mino.rotation = Rotation.Start;
        mino.posX = 3;
        mino.posY = 3;
        return mino;
    }
    public void move(int x, int y){
        mino.posX += x;
        mino.posY += y;
    }
    public void rotateWhile(int direction, Predicate<Mino> action){
        Rotation oldRotation = mino.rotation;
        mino.rotation = Rotation.getRotation(mino.rotation.index + direction);
        int[][] tests = offsets.get(mino.type, oldRotation, mino.rotation);

        for (int test = 0; test < tests.length-1; test++){
            int x = tests[test][0],
                y = tests[test][0];
            mino.addXY(x, y);

            if(action.test(mino)) return; // Mino fits
            else mino.addXY(-x,-y);
        }
        mino.rotation = oldRotation;
    }
    public void hold(){
        heldMino.hold(mino, nextMinos);
    }
}
