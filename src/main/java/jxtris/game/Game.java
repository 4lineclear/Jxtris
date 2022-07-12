package jxtris.game;

import jxtris.game.base.glue.GameBus;
import jxtris.game.base.glue.GameLoop;
import jxtris.game.base.rendering.RenderBus;
import jxtris.game.base.rendering.Renderer;
import jxtris.game.base.state.BaseGame;

/**
 * Central class for the game
 * Assembles and directs all the components, similar to a model
 **/
public class Game {
    private final GameLoop gameLoop;
    public Game(BaseGame game, GameBus gameBus, Renderer renderer, RenderBus renderBus){
        renderBus.init(game.getState(), renderer);
        this.gameLoop = new GameLoop() {
            @Override
            public void tick(long elapsed) {
                gameBus.increment(elapsed);
                renderBus.renderAll(game.getState());
            }
        };
    }
    public void start() {
        gameLoop.start();
    }
}
