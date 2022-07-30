package jxtris.game.base.state.piece;

import java.util.function.Predicate;

public class GhostMino {
    public int posY;
    private final Predicate<Mino> minoCheckAction;

    public GhostMino(Predicate<Mino> minoCheckAction) {
        this.minoCheckAction = minoCheckAction;
    }
    public void calculatePosition(Mino mino){
        posY = 0;
        while (minoCheckAction.test(mino)) {
            mino.posY++;
            posY++;
        }
        int temp = mino.posY;
        mino.posY -= posY;
        posY = temp-1 ;
    }
}
