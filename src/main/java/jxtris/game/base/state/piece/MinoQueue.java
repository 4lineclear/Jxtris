package jxtris.game.base.state.piece;

import jxtris.game.base.state.Block;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class MinoQueue {
    //TODO: DOCUMENT EVERYTHING HERE
    private final int numBlocks;
    private final Block[][] minoBuffer;
    private int bufferNum;
    private int head;

    public MinoQueue() {
        final Block[] blocks = new Block[]{Block.I, Block.J, Block.O, Block.L, Block.S, Block.T, Block.Z};
        head = 0;
        bufferNum = 0;
        numBlocks = 7;
        minoBuffer = new Block[2][numBlocks];
        System.arraycopy(blocks, 0, minoBuffer[0], 0, numBlocks);
        System.arraycopy(blocks, 0, minoBuffer[1], 0, numBlocks);
        shuffleCurrentBuffer();
        bufferNum = 1;
        shuffleCurrentBuffer();
        bufferNum = 0;
    }
    public Block next(){
        if(head > 6){
            shuffleCurrentBuffer();
            bufferNum = 1 - bufferNum;
            head = 0;
        }
        return minoBuffer[bufferNum][head++];
    }
    private void shuffleCurrentBuffer(){
        Random rnd = ThreadLocalRandom.current();
        for (int i = numBlocks - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            Block temp = minoBuffer[bufferNum][index];
            minoBuffer[bufferNum][index] = minoBuffer[bufferNum][i];
            minoBuffer[bufferNum][i] = temp;
        }
    }
    public Block[] getNextMinos(){
        Block[] nextMinos = new Block[5];
        int len = head > 2 ? 7 - head : 5;
        System.arraycopy(minoBuffer[bufferNum], head, nextMinos, 0, len);
        System.arraycopy(minoBuffer[1-bufferNum], 0, nextMinos, len, 5-len);
        return nextMinos;
    }
}
