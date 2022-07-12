package jxtris.game.base.rendering;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import jxtris.game.base.state.Block;
import jxtris.game.base.state.Line;

public class Renderer {
    private final int size;
    private final GraphicsContext context;
    public Renderer(GraphicsContext context){
        this.context = context;
        context.translate(60,60);
        this.size = 30;
        context.setFill(Color.RED);
    }
    private void renderBlock(int x, int y){
        context.fillRect(size*x + x, size*y + y, size, size);
    }
    public void renderMatrix(Line[] rows){
        int j = 0;
        for(Line row : rows) {
            int i = 0;
            for (Block ignored : row.row)
                renderBlock(i++,j);
            j++;
            if(j > 19) return;
        }
    }
}
