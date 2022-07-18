package jxtris.game.base.rendering;

import javafx.scene.canvas.GraphicsContext;
import jxtris.game.base.state.Block;
import jxtris.game.base.state.Line;
import jxtris.game.base.state.piece.Mino;

public abstract class BaseRenderer {
    private final GraphicsContext context;
    private final int size;
    protected BaseRenderer(GraphicsContext context){
        this.context = context;
        size = 25;
    }
    public void renderMatrix(Line[] lines) {
        for (int i = 4; i < lines.length; i++) {
            for (int j =0; j < lines[i].getBlocks().length; j++) {
                context.setFill(lines[i].getBlock(j).color);
                context.fillRect(size*j + j,size*i + i,size,size);
            }
        }
    }

    public void renderNextMino(Block[] blocks) {
    }

    public void renderHeldMino(Block block) {
    }

    public void renderMino(Mino mino) {
        context.setFill(mino.type.color);
        for (int i = 0; i < 4; i++) {
            int x = mino.x(i), y = mino.y(i);
            if(y < 4)
                continue;
            context.fillRect(size*x + x,size*y + y, size, size);
        }
    }
}
