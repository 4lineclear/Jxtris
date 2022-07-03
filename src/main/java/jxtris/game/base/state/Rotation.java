package jxtris.game.base.state;

public enum Rotation {
    Start(0),
    Right(1),
    Double(2),
    Left(3);
    Rotation(int index){
        this.index = index;
    }
    public final int index;
}
