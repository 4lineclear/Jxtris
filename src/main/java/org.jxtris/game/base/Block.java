package org.jxtris.game.base;

public record Block(int x, int y, BlockType type) {
    @Override
    public int hashCode() {
        return x + y * 10;
    }

    public boolean equals(Block block) {
        if (this == block) return true;
        return x == block.x && y == block.y;
    }
}
