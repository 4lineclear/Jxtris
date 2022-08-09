package jxtris.game;

import javafx.animation.AnimationTimer;
import jxtris.game.base.glue.gameBus.GameBus;
import jxtris.game.base.glue.RenderBus;
import jxtris.game.base.rendering.BaseRenderer;
import jxtris.game.base.state.BaseGame;
import jxtris.game.controls.KeyPoller;

public class Game extends AnimationTimer {

    private double startTime;
    private double previousTime;
    private final GameBus gameBus;
    private final RenderBus renderBus;
    public Game(BaseGame game, BaseRenderer renderer){
        this.gameBus = new GameBus(game);
        this.renderBus = new RenderBus(renderer, game.getState());
        KeyPoller.getInstance().setGameBus(gameBus);
    }
    @Override
    public void start(){
        startTime = System.nanoTime();
        previousTime = startTime;
        super.start();
    }
    @Override
    public void handle(long now) {
        gameBus.increment((now - previousTime) / 1e6 );
        previousTime = now;
        renderBus.renderChanges(gameBus.getState());
    }
}
