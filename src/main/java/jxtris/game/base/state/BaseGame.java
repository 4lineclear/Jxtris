package jxtris.game.base.state;

import java.util.*;

public abstract class BaseGame {
    private boolean currentMinoHeld;
    private Block heldMino;
    private final Mino mino;
    private final Matrix matrix;
    private final Queue<Block> nextMinos;

    protected BaseGame() {
        currentMinoHeld = false;
        heldMino = Block.X;
        mino = new Mino();
        matrix = new Matrix();
        nextMinos = new MinoQueue();
        mino.setMino(nextMinos.remove(), Rotation.Start, 3 ,4);
    }
    private void placeMino(){
        matrix.placeMino(mino);
        currentMinoHeld = false;
        mino.type = nextMinos.remove();
    }
    public void move(int x, int y){
        mino.posX += x;
        mino.posY += y;
        if(!matrix.checkMino(mino)){
            mino.posX -=x;
            mino.posY -= y;
        }
    }
    public void rotate(int direction){
        Rotation newRotation = Rotation.getRotation(mino.rotation.index + direction);
        rotate(newRotation);
    }
    private void rotate(Rotation newRotation){
        Rotation oldRotation = mino.rotation;
        mino.rotation = newRotation;
        if(!matrix.checkMino(mino))
            mino.rotation = oldRotation;
    }
    public void hold(){
        if(this.currentMinoHeld)
            return;
        if(heldMino == Block.X)
            heldMino = nextMinos.remove();
        Block temp = this.heldMino;
        this.heldMino = mino.type;
        mino.type = temp;
        currentMinoHeld = true;
    }
    public State getState(){
        return new State(mino, heldMino, nextMinos, matrix.getRows());
    }
    private static class MinoQueue extends ArrayDeque<Block>{
        private final Block[] blocks;

        private MinoQueue() {
            blocks = new Block[]{
                    Block.I, Block.J, Block.O, Block.L, Block.S , Block.T, Block.Z
            };
            generateNextMinos();
            generateNextMinos();
        }

        @Override
        public Block remove() {
            return super.remove();
        }
        public void generateNextMinos(){
            List<Block> newBlocks = Arrays.asList(blocks);
            Collections.shuffle(newBlocks);
            this.addAll(newBlocks);
        }
    }
}
