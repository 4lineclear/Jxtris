package jxtris.game.base.state;

import java.util.Arrays;

public class Matrix {
    private final Line[] rows;

    public Matrix() {
        rows = new Line[24];
        for (int i = 0; i < rows.length; i++)
            rows[i] = new Line();

    }
    public void addMino(Mino mino, int x, int y){
        for(int[] xy : mino.getBlock())
            this.rows[xy[1] + y].setBlock(xy[0] + x, mino.type);
    }
    public void print(){
        for(Line row : rows) {
            for (int i = 0; i < 10; i++)
                System.out.print(row.getBlock(i) + " ");
            System.out.println();
        }
    }
    public boolean checkMino(Mino mino, int x, int y){
        return false;
    }
}
