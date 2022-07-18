package jxtris.game.base.glue;

import jxtris.game.base.rendering.BaseRenderer;
import jxtris.game.base.state.GameState;

public class RenderBus {
    private final BaseRenderer renderer;
    private GameState previousState;

    public RenderBus(BaseRenderer renderer, GameState startingState) {
        this.renderer = renderer;
        this.previousState = startingState;
    }
    public void renderChanges(GameState gameState){
//        System.out.println(gameState);
        if (gameState.compareMatrix(previousState))
            renderer.renderMatrix(gameState.lines());
        if (gameState.compareMino(previousState))
            renderer.renderMino(gameState.mino());
        else {
            System.out.println("Shit");
        }
        if (gameState.compareHeldMino(previousState))
            renderer.renderHeldMino(gameState.heldMino());
        if (gameState.compareNextMino(previousState))
            renderer.renderNextMino(gameState.nextMinos());
        previousState = gameState;
    }
}
