package jxtris.game.base.rendering;

import jxtris.game.base.state.State;

public class RenderBus {
    private State previousState;
    private Renderer renderer;
    public void init(State firstState, Renderer renderer){
        previousState = firstState;
        this.renderer = renderer;
    }
    public void renderAll(State changes){
        renderer.renderMatrix(changes.rows());
    }
}
