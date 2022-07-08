package jxtris.game.base.state;

import java.util.*;

public abstract class BaseGame {
    private final Mino mino;
    private final Matrix matrix;
    private final Queue<Block> nextMinos;
    final Block[] blocks;
    protected BaseGame() {
        blocks = new Block[]{Block.I, Block.J, Block.O, Block.L, Block.S , Block.T, Block.Z};
        mino = new Mino();
        matrix = new Matrix();
        nextMinos = new ArrayDeque<>();
        generateNextMinos();
        generateNextMinos();
    }
    private void generateNextMinos(){
        List<Block> newBlocks = Arrays.asList(blocks);
        Collections.shuffle(newBlocks);
        nextMinos.addAll(newBlocks);
    }
    protected void move(int x, int y){

    }
    protected void rotate(int direction){

    }
    protected void softDrop(){

    }
    protected void hardDrop(){

    }
    protected boolean hold(){
        return false;
    }

}
