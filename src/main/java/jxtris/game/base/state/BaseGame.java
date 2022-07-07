package jxtris.game.base.state;

public abstract class BaseGame {
    private final Mino currentMino;
    private final Matrix matrix;
    protected BaseGame() {
        currentMino = new Mino();
        matrix = new Matrix();
    }

}
