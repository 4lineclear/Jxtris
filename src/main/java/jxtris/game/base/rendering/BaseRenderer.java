package jxtris.game.base.rendering;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import jxtris.game.base.state.Block;
import jxtris.game.base.state.Line;
import jxtris.game.base.state.Rotation;
import jxtris.game.base.state.piece.Mino;

public abstract class BaseRenderer {
    private final GraphicsContext context;
    private final int size, matrixXStart, matrixYStart;
    protected BaseRenderer(GraphicsContext context){
        this.context = context;
        size = 25;
        matrixXStart = 5;
        matrixYStart = 4;
    }
    private void fillBlock(int x, int y){
        context.fillRect(size*x + x + matrixXStart*size, size*y + y, size, size);
    }
    private void fillMino(Block block, Rotation rotation, int x, int y){

    }
    public void renderMatrix(Line[] lines) {
        for (int i = 4; i < lines.length; i++) {
            for (int j =0; j < lines[i].getBlocks().length; j++) {
                context.setFill(lines[i].getBlock(j).color);
                fillBlock(j,i);
            }
        }
    }

    public void renderNextMino(Block[] blocks) {
        context.clearRect((matrixXStart + 11)*size, matrixYStart*size, size*5, size*15);
        for (int i = 0; i < blocks.length; i++){
            context.setFill(blocks[i].color);
            for(int j = 0; j < 4; j++){
                int x = Mino.x(blocks[i], Rotation.Start, j),
                    y = Mino.y(blocks[i], Rotation.Start, j);
                fillBlock(x + 11,y + 3*i + matrixYStart);
            }
        }
    }

    public void renderHeldMino(Block block) {
        if(block == Block.X)
            return;
        context.setFill(block.color);
        for(int i = 0; i < 4; i++){
            int x = Mino.x(block, Rotation.Start, i),
                y = Mino.y(block, Rotation.Start, i);
            fillBlock(x-4,y + matrixYStart);
        }
    }

    public void renderMino(Mino mino) {
        context.setFill(mino.type.color);
        for (int i = 0; i < 4; i++) {
            int x = mino.x(i), y = mino.y(i);
            if(y < 4)
                continue;
            fillBlock(x,y);
        }
    }
}
