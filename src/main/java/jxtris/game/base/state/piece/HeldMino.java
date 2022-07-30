package jxtris.game.base.state.piece;

import jxtris.game.base.state.Block;

public class HeldMino {
    public boolean currentMinoHeld;

    public Block held;
    public HeldMino(){
        currentMinoHeld = false;
        held = Block.X;
    }
    public boolean hold(Mino mino, MinoQueue nextMinos){
        if(currentMinoHeld)
            return false;
        if(held == Block.X)
            held = nextMinos.next();
        Block temp = held;
        held = mino.type;
        mino.type = temp;
        currentMinoHeld = true;
        return true;
    }

}
