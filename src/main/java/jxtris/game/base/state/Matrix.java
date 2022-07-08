package jxtris.game.base.state;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.function.Consumer;

public class Matrix {
    private final Line[] rows;

    private final HashSet<Integer> lineBuffer;

    public Matrix() {
        rows = new Line[24];
        for (int i = 0; i < rows.length; i++)
            rows[i] = new Line();

        lineBuffer = new HashSet<>(4);
    }
    public void addMino(Mino mino, int posX, int posY){
        int rowNum = 0;
        for(int i = 0; i < mino.length; i++)
            if(this.rows[mino.y(i)].setBlock(mino.x(i), mino.type))
                lineBuffer.add(mino.y(i) > 0 ? rowNum = mino.y(i) : mino.y(i));

        if(lineBuffer.size() > 0)
            clear(rowNum, lineBuffer.size());

        lineBuffer.clear();
    }
    public boolean checkMino(Mino mino, int posX, int posY){
        for (int i = 0; i < mino.length; i++)
            if(checkBounds(mino.x(i),mino.y(i)) || this.rows[mino.y(i)].getBlock(mino.x(i)) != Block.X)
                return false;

        return true;
    }
    //TODO:Implement checkBlock()
    private boolean checkBlock(){
        return false;
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
            rows[i].clear();
        }
    }
}
