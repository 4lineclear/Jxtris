package jxtris.game.base.glue;

public class MoveTimer extends ScheduledTimer{
    public int leftOver;

    public MoveTimer(long goal) {
        super(goal);
    }
}
