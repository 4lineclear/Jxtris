package jxtris.game.base.state.piece;

import jxtris.game.base.state.Rotation;

import java.util.function.Predicate;

public class Piece {
    public final Mino mino;
    public final GhostMino ghostMino;
    public final HeldMino heldMino;
    public final MinoQueue nextMinos;
    private final Offsets offsets;
    private final Predicate<Mino> minoCheckAction;

    public Piece(Predicate<Mino> minoCheckAction) {
        mino = new Mino();
        ghostMino = new GhostMino(minoCheckAction);
        heldMino = new HeldMino();
        nextMinos = new MinoQueue();
        offsets = new Offsets();
        this.minoCheckAction = minoCheckAction;

        iterateMino();
        ghostMino.calculatePosition(mino);
    }
    public void iterateMino(){
        heldMino.currentMinoHeld = false;
        mino.type = nextMinos.next();
        resetMino();
    }
    public void move(int x, int y){
        mino.posX += x;
        mino.posY += y;
        ghostMino.calculatePosition(mino);
    }
    public void rotateWhile(int direction){
        Rotation oldRotation = mino.rotation;
        mino.rotation = Rotation.getRotation(mino.rotation.index, direction);
        int[][] tests = offsets.get(mino.type, oldRotation, mino.rotation);

        for (int test = 0; test < tests.length-1; test++){
            int x = tests[test][0],
                y = tests[test][1];
            mino.addXY(x, y);

            if(minoCheckAction.test(mino)) {
                ghostMino.calculatePosition(mino);
                return;
            } // Mino fits
            else mino.addXY(-x,-y);
        }
        mino.rotation = oldRotation;
    }
    public void hold(){
        if(heldMino.hold(mino, nextMinos))
            resetMino();
    }
    private void resetMino(){
        mino.rotation = Rotation.Start;
        mino.posX = 3;
        mino.posY = 3;
        ghostMino.calculatePosition(mino);
    }
}
