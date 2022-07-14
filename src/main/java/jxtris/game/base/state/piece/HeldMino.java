package jxtris.game.base.state.piece;

import jxtris.game.base.state.Block;

public class HeldMino {
    private boolean currentMinoHeld;

    private Block held;
    public HeldMino(){
        currentMinoHeld = false;
        held = Block.X;
    }
    public boolean hold(Mino mino, MinoQueue nextMinos){
        if(currentMinoHeld)
            return false;
        if(held == Block.X)
            held = nextMinos.getNext();
        Block temp = held;
        held = mino.type;
        mino.type = temp;
        return currentMinoHeld = true;
    }

    public void setHeld(boolean newHeld) {
        currentMinoHeld = newHeld;
    }
}
