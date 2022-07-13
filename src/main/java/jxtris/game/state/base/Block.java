package jxtris.game.state.base;

public enum Block {
    I(0),
    J(1),
    O(2),
    L(3),
    S(4),
    T(5),
    Z(6),
    X(-1);
    public final int index;

    Block(int blockNum) {
        this.index = blockNum;
    }
}
