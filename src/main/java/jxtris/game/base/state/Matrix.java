package jxtris.game.base.state;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class Matrix {
    private final Line[] rows;

    private final HashSet<Integer> lineBuffer;

    public Matrix() {
        rows = new Line[24];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new Line();
        }

        lineBuffer = new HashSet<>(4);
        rows[20].setBlock(5, Block.I);
        rows[23].setBlock(5, Block.I);
    }
    public void addMino(Mino mino, int posX, int posY){
        int rowNum = 0;
        for(int[] xy : mino.getBlocks()){
            int x = xy[0] + posX;
            int y = xy[1] + posY;
            if(this.rows[y].setBlock(x, mino.type))
                lineBuffer.add(y > rowNum ? rowNum = y : y);

        }
        if(lineBuffer.size() > 0)
            clear(rowNum, lineBuffer.size());
        lineBuffer.clear();
    }
    public void print(){
        for(Line row : rows) {
            for (int i = 0; i < 10; i++)
                System.out.print(row.getBlock(i) + " ");
            System.out.println();
        }
    }
    public boolean checkMino(Mino mino, int posX, int posY){
        for(int[] xy : mino.getBlocks()) {
            int x = xy[0] + posX;
            int y = xy[1] + posY;
            if (checkBounds(x,y) || this.rows[y].getBlock(x) != Block.X)
                return false;
        }
        return true;
    }
    private boolean checkBounds(int x, int y){
        return x > 0 && x < 9 && y > 0 && y < 23;
    }

    public void clear(int rowNum, int count){
        int i = rowNum;
        int j = rowNum - 1;
        for(; i > count; i--){
            while(lineBuffer.contains(j)) j--;
            rows[i].clear(rows[j--]);
        }


        for(; i >= 0; i--) {
            System.out.println(i);
            rows[i].clear();
        }
    }
}
