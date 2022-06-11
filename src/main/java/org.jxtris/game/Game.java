package org.jxtris.game;

import org.jxtris.game.base.glue.GameBus;
import org.jxtris.game.base.glue.GameLoop;
import org.jxtris.game.base.rendering.RenderBus;
import org.jxtris.game.base.rendering.Renderer;
import org.jxtris.game.base.state.BaseGame;

/**
 * Central class for the game
 * Assembles and directs all the components, similar to a model
 **/
public class Game {
    public Game(BaseGame game, GameBus gameBus, Renderer renderer, RenderBus renderBus){
        GameLoop gameLoop = new GameLoop() {
        };
    }
}
