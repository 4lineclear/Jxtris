package main.java.game.gameModel;

/**
 * The block Jxtris is made up of
 * <p>
 * X block is an empty block, all other blocks are meant to be from a Tetramino
 * </p>
 **/
public enum Block {
    I(0),
    J(1),
    O(2),
    L(3),
    S(4),
    T(5),
    Z(6),
    X(7);
    public final int blockNum;
    Block(int blockNum){
        this.blockNum = blockNum;
    }

}
