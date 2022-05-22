package org.jxtris.game.base;

import java.util.HashSet;
import java.util.Set;

public class Matrix {
    private final Line[] placedPieces;
    private final Block bounds;
    protected Matrix() {
        placedPieces = new Line[24];
        bounds = new Block(10, 24, BlockType.X);
    }

    private void placeMino(Mino mino) {
        for (Block block : mino) {
            if (!block.equals(bounds) || !placedPieces[block.y()].contains(block))
                return;
        }

        for (Block block : mino) {
            placedPieces[block.y()].add(block);
        }
    }
}
