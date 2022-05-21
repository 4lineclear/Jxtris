package org.jxtris.game.base;

import java.util.HashSet;
import java.util.Set;

public class Matrix {
    private final Set<Block> placedPieces;
    private final Block bounds;

    protected Matrix() {
        placedPieces = new HashSet<>(200);
        bounds = new Block(10, 20, BlockType.X);
    }

    private void placeMino(Mino mino) {
        for (Block block : mino) {
            if (!block.equals(bounds) || !placedPieces.contains(block))
                return;
        }

        for (Block block : mino) {
            placedPieces.add(block);
        }
    }
}
