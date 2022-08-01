package jxtris.game.base.glue;

public class ScheduledTimer implements Schedulable{
    private long value = 0;
    private final long goal;
    private boolean scheduled = false;

    public ScheduledTimer(long goal) {
        this.goal = goal;
    }

    public void schedule(){
        scheduled = true;
    }

    public void increment(long increment){
        if(!scheduled) return;
        value += increment;
    }
    public void reset(){
        value = 0;
        scheduled = false;
    }
    public boolean scheduled(){
        return scheduled;
    }
    public boolean goalReached(){
        return value > goal;
    }

}
