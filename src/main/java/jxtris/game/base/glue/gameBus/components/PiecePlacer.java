package jxtris.game.base.glue.gameBus.components;

public class PiecePlacer extends ScheduledTimer {
    private boolean interrupted;
    private final long originalGoal;
    private long accumulated;

    public PiecePlacer(long goal) {
        super(goal);
        originalGoal = goal;
    }
    public void interrupt(){
        interrupted = true;
    }
    public boolean applyInterrupt(){
        if(!interrupted) return true;
        interrupted = false;
        return (goal+=500) >= 5500;
    }
    public long applyGravity(){
        return 1000 - ( 100 * (accumulated/500) );
    }

    @Override
    public void reset() {
        System.out.println(value + " " + goal + " " + accumulated);
        super.reset();
        accumulated +=500;
        goal = originalGoal;
        interrupted = false;
    }
    public void hardReset(){
        reset();
        accumulated = 0;
    }
}
