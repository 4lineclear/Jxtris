package jxtris.game.base.state;

public class Line {
    private Block[] row;
    private int blockNum;
    public Line(){
        this.blockNum = 0;
        this.row = new Block[10];
        for (int i = 0; i < row.length; i++)
            this.row[i] = Block.X;
    }
    public Block getBlock(int index){
        return this.row[index];
    }
    public boolean setBlock(int index, Block block){
        this.blockNum++;
        this.row[index] = block;
        return blockNum > 9;
    }
    public void clear(Block[] row){
        this.blockNum = 0;
        this.row = row;
    }
}
