package org.jxtris.game.base;

public abstract class BaseGame {
    private final Matrix matrix;

    private Mino current;

    protected BaseGame() {
        matrix = new Matrix();
    }
}
