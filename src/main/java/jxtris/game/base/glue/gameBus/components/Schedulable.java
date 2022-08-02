package jxtris.game.base.glue.gameBus.components;

public interface Schedulable {
    void schedule();
    boolean scheduled();
    void reset();
}
