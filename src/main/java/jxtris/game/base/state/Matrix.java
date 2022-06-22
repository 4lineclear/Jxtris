package jxtris.game.base.state;

public class Matrix {
    private final Line[] rows;

    public Matrix() {
        rows = new Line[24];
    }
    public void addMino(Mino mino, int x, int y){

    }
    public boolean checkMino(Mino mino, int x, int y){
        return false;
    }
}
