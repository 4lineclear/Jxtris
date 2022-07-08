package jxtris.game.base.state;

public enum Rotation {
    Start(0),
    Left(1),
    Double(2),
    Right(3);
    Rotation(int index){
        this.index = index;
    }
    public final int index;
}
