package jxtris.game.base.state;

public enum Rotation {
    Start(0),
    Left(1),
    Double(2),
    Right(3);

    public final int index;

    Rotation(int index) {
        this.index = index;
    }
    public static Rotation getRotation(int oldIndex, int direction) {
        int key = oldIndex + direction;
        if(key > 3 )
            key -=4;
        else if(key < 0)
            key +=4;

        return switch (key) {
            case 0 -> Start;
            case 1 -> Left;
            case 2 -> Double;
            case 3 -> Right;
            default -> throw new IllegalStateException("Index: " + oldIndex + " with the direction: " + direction + " is not allowed");
        };
    }

    public static Rotation getRotation(int index) {
        return switch (index) {
            case 0 -> Start;
            case 1 -> Left;
            case 2 -> Double;
            case 3 -> Right;
            default -> throw new IllegalStateException("Index: " + index + " is not allowed, must be an Integer 0-3");
        };
    }
}