package jxtris.game.base.glue;

import javafx.animation.AnimationTimer;

public abstract class GameLoop extends AnimationTimer {
    long startTime;
    long previousTime;
    @Override
    public void start(){
        startTime = System.nanoTime();
        previousTime = startTime;
        super.start();
    }
    @Override
    public void handle(long now) {
        tick( (long) ((now - previousTime) / 1e6));
        previousTime = now;
    }
    /**
     * A tick of the game
     * <br>
     * Should run every 16 milliseconds, but can deviate
     * @param elapsed The milliseconds since the last frame
     **/
    public abstract void tick(long elapsed);
}
