package jxtris.game.base.glue.gameBus.components;

public class PiecePlacer extends ScheduledTimer {
    private final double originalGoal;
    private int softInterruptCounter;
    private boolean softInterrupt, hardInterrupt, forcePlace;
    public PiecePlacer(double goal) {
        super(goal);
        originalGoal = goal;
    }

    @Override
    public void reset(){
        super.reset();
        goal = originalGoal;
        softInterrupt = false;
        hardInterrupt = false;
        softInterruptCounter = 0;
        forcePlace = false;
    }

    @Override
    public boolean goalReached() {
        if(super.goalReached())
            applyInterrupt();
        return super.goalReached();
    }

    public void applyInterrupt(){
        if(hardInterrupt){
            goal+=500;
            softInterruptCounter = 0;
            scheduled = false;
        } else if (softInterrupt) {
            goal+=500;
            if(++softInterruptCounter > 10)
                forcePlace = true;
        }
        if(goal > 20000)
            forcePlace = true;
        hardInterrupt = false;
        softInterrupt = false;
    }
    public void softInterrupt(){
        softInterrupt = true;
    }
    public void hardInterrupt(){
        hardInterrupt = true;
    }

    public boolean forcePlace() {
        return forcePlace;
    }
}
