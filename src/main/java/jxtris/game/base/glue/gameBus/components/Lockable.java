package jxtris.game.base.glue.gameBus.components;

public interface Lockable {
    void lock();
    boolean locked();
    void reset();
}
