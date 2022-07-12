package jxtris.game.base.state;

import java.util.HashSet;

public class Matrix {
    private final Line[] rows;

    private final HashSet<Integer> lineBuffer;

    public Matrix() {
        rows = new Line[24];
        for (int i = 0; i < rows.length; i++)
            rows[i] = new Line();

        lineBuffer = new HashSet<>(4);
    }
    public void placeMino(Mino mino){
        int rowNum = 0;
        for(int i = 0; i < mino.length; i++)
            if(this.rows[mino.y(i)].setBlock(mino.x(i), mino.type))
                lineBuffer.add(mino.y(i) > 0 ? rowNum = mino.y(i) : mino.y(i));

        if(lineBuffer.size() > 0)
            clear(rowNum, lineBuffer.size());

        lineBuffer.clear();
    }
    public boolean checkMino(Mino mino){
        for (int i = 0; i < mino.length; i++)
            if(checkBounds(mino.x(i), mino.y(i)))
                return false;

        return true;
    }
    private boolean checkBlock(int x, int y){
        return checkBounds(x,y) || this.rows[y].getBlock(x) != Block.X;
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

    public Line[] getRows() {
        return rows;
    }
}
