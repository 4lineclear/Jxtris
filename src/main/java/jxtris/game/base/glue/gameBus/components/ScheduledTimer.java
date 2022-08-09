package jxtris.game.base.glue.gameBus.components;

public class ScheduledTimer implements Schedulable, Incrementable {
    protected double value, goal;
    protected boolean scheduled = false;

    public ScheduledTimer(double goal) {
        this.goal = goal;
    }

    public void schedule(){
        scheduled = true;
    }

    public void increment(double increment){
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
