package jxtris.game.base.state;

import java.util.Arrays;

public class Line {
    private Block[] row;
    private int blockNum;

    public Line() {
        this.blockNum = 0;
        this.row = new Block[10];
        for (int i = 0; i < row.length; i++)
            this.row[i] = Block.X;
    }

    public Block[] getBlocks() {
        return this.row;
    }

    public Block getBlock(int index) {
        return this.row[index];
    }

    public boolean setBlock(int index, Block block) {
        this.blockNum++;
        this.row[index] = block;
        return blockNum > 9;
    }

    public void clear(Line line) {
        this.blockNum = line.blockNum;
        System.arraycopy(line.row, 0, this.row, 0, this.row.length);
    }

    public void clear() {
        this.blockNum = 0;
        Arrays.fill(row, Block.X);
    }
    public boolean compare(Line line){
        for (int i = 0; i < this.row.length; i++)
            if (line.row[i] != this.row[i]) {
                return false;
            }
        return true;
    }

    @Override
    public String toString() {
        return "Line{" +
                "row=" + Arrays.toString(row) +
                ", blockNum=" + blockNum +
                '}';
    }
}
