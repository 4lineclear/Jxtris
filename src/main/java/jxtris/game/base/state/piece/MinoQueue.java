package jxtris.game.base.state.piece;

import jxtris.game.base.state.Block;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public class MinoQueue {
    //TODO: DOCUMENT EVERYTHING HERE
    private final int numBlocks;
    private final Block[][] nextBlocks;
    private int bufferNum;
    private int head;

    public MinoQueue() {
        final Block[] blocks = new Block[]{Block.I, Block.J, Block.O, Block.L, Block.S, Block.T, Block.Z};
        head = 0;
        bufferNum = 0;
        numBlocks = 7;
        nextBlocks = new Block[2][numBlocks];
        System.arraycopy(blocks, 0, nextBlocks[0], 0, numBlocks);
        System.arraycopy(blocks, 0, nextBlocks[1], 0, numBlocks);
        shuffleCurrentBuffer();
        bufferNum = 1;
        shuffleCurrentBuffer();
        bufferNum = 0;
    }
    public Block getNext(){
        if(head > 5){
            shuffleCurrentBuffer();
            bufferNum = 1 - bufferNum;
            head = 0;
        }
        return nextBlocks[bufferNum][head++];
    }
    private void shuffleCurrentBuffer(){
        Random rnd = ThreadLocalRandom.current();
        for (int i = numBlocks - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            Block temp = nextBlocks[bufferNum][index];
            nextBlocks[bufferNum][index] = nextBlocks[bufferNum][i];
            nextBlocks[bufferNum][i] = temp;
        }
    }
    public void forNextMinos(Consumer<Block> action){
        int i = head;
        for (;i < 7 && i - head < 5; i++)
            action.accept(nextBlocks[bufferNum][i]);
        for(i = 0; i < head - 2; i++)
            action.accept(nextBlocks[1-bufferNum][i]);

    }
}
