package jxtris.game.base.state;

import jxtris.game.base.state.piece.Mino;

import java.util.Arrays;

public record GameState(Mino mino, Block heldMino, Block[] nextMinos, Line[] lines) {
    public boolean compareMino(GameState gameState){
        return gameState.mino.type == this.mino.type &&
                gameState.mino.rotation == this.mino.rotation &&
                gameState.mino.posX == this.mino.posX &&
                gameState.mino.posY == this.mino.posY;
    }
    public boolean compareHeldMino(GameState gameState){
        return gameState.heldMino == this.heldMino;
    }
    public boolean compareNextMino(GameState gameState){
        for (int i = 0; i < this.nextMinos.length; i++)
            if (gameState.nextMinos[i] != this.nextMinos[i])
                return false;
        return true;
    }
    public boolean compareMatrix(GameState gameState) {
        for (int i = 0; i < this.lines.length; i++)
            if (!gameState.lines[i].compare(this.lines[i]))
                return false;

        return true;
    }
    @Override
    public String toString() {
        return "GameState{" +
                "type=" + mino.type +
                ", rotation=" + mino.rotation +
                ", posX=" + mino.posX +
                ", posY=" + mino.posY +
                ", heldMino=" + heldMino +
                ", nextMinos=" + Arrays.toString(nextMinos) +
                ", lines=" + Arrays.toString(lines) +
                '}';
    }
}
