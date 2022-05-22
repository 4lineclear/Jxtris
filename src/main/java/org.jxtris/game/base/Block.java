package org.jxtris.game.base;

public class Block {
    private int x;
    private int y;
    private final BlockType type;

    public Block(int x, int y, BlockType type){
        this.x = x;
        this.y = y;
        this.type = type;
    }
    public Block(int x, int y){
        this.x = x;
        this.y = y;
        this.type = BlockType.X;
    }
    @Override
    public int hashCode() {
        return x + y * 10;
    }
    public boolean equals(Block block) {
        if (this == block) return true;
        return x == block.x && y == block.y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public void x(int x) {
        this.x = x;
    }

    public void y(int y) {
        this.y = y;
    }

    public BlockType type() {
        return type;
    }
}
