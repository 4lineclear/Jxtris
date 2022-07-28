package jxtris.game.base.state;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public enum Block {
    I(0, Color.CYAN),
    J(1, Color.BLUE),
    O(2, Color.YELLOW),
    L(3, Color.ORANGE),
    S(4, Color.GREEN),
    T(5, Color.PURPLE),
    Z(6, Color.RED),
    X(-1, Color.BLACK);
    public final int index;
    public final Color color;

    Block(int blockNum, Color color) {
        this.index = blockNum;
        this.color = color;
    }
}
