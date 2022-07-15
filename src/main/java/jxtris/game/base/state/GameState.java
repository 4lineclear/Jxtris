package jxtris.game.base.state;

import java.util.Arrays;

public record GameState(Block currentMino, Rotation rotation, int posX, int posY, Block heldMino, Block[] nextMinos, Line[] lines) {
    @Override
    public String toString() {
        return "GameState{" +
                "currentMino=" + currentMino +
                ", rotation=" + rotation +
                ", posX=" + posX +
                ", posY=" + posY +
                ", heldMino=" + heldMino +
                ", nextMinos=" + Arrays.toString(nextMinos) +
                ", lines=" + Arrays.deepToString(lines) +
                '}';
    }
}
