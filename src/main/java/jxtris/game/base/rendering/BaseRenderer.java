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
        context.setFill(block.color);
        for (int i = 0; i < 4; i++) {
           int totalX = Mino.x(block, rotation, i) + x;
           int totalY = Mino.y(block, rotation, i) + y;
            if(totalY < 4)
                continue;
            fillBlock(totalX, totalY);
        }

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
        for (int i = 0; i < blocks.length; i++)
            fillMino(blocks[i], Rotation.Start, 11, 3*i + matrixYStart);

    }

    public void renderHeldMino(Block block) {
        int renderPos = -4;
        if(block == Block.X)
            return;
        if (block == Block.I )
            renderPos = - 5;
        context.clearRect(size*(matrixXStart - 5), matrixYStart*size, size*4, size*3);
        fillMino(block, Rotation.Start, renderPos, matrixYStart);
    }

    public void renderMino(Mino mino) {
        fillMino(mino.type, mino.rotation, mino.posX, mino.posY);
    }

    public void renderGhostMino(Mino mino, int ghostPos) {
        fillMino(mino.type, mino.rotation, mino.posX, ghostPos);
    }
}
