package org.jxtris.game.base;

public abstract class BaseGame {
    private final Matrix matrix;
    private Mino current;

    private Block pos;
    protected BaseGame() {
        matrix = new Matrix();
    }
    public void start(){
        pos = new Block(4,0);
    }
    public void moveLeft(){

    }
    public void moveRight(){

    }
    public void rotateLeft(){

    }
    public void rotateRight(){

    }
    public void softDrop(){

    }
    public void hardDrop(){

    }
    public void rotate180(){

    }
    public void hold(){

    }
    public void restart(){

    }
    public void escape(){

    }

}
