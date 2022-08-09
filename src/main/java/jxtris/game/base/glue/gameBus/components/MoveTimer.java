package jxtris.game.base.glue.gameBus.components;

public class MoveTimer extends ScheduledTimer {
//    public int leftOver;
    private boolean canceled;

    public MoveTimer(double goal) {
        super(goal);
    }
    public void cancel(){
        if(!scheduled)return;
        reset();
        canceled = true;
    }
    public boolean canceled(){
        if(!canceled)
            return false;
        canceled = false;
        return true;
    }
}
