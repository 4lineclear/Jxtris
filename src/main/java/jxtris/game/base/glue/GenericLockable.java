package jxtris.game.base.glue;

public class GenericLockable implements Lockable{
    private boolean locked;
    @Override
    public void lock() {
        locked = true;
    }

    @Override
    public boolean locked() {
        return locked;
    }

    @Override
    public void reset() {
        locked = false;
    }
}
