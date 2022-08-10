package jxtris.game.base.glue.gameBus.components;

public class GravityTimer extends ScheduledTimer{
    private final double originalGravity, softDropGoal;
    public GravityTimer(double goal, double softDropGoal) {
        super(goal);
        originalGravity = goal;
        this.softDropGoal = softDropGoal;
    }
    @Override
    public void increment(double increment) {
        value += increment;
    }

    public void scheduleSoftDrop() {
        goal = softDropGoal;
    }
    public void stopSoftDrop(){
        goal = originalGravity;
    }
}
