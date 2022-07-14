package jxtris.game.base.state.piece;

import jxtris.game.base.state.Block;
import jxtris.game.base.state.Rotation;

public class Mino {

    public final int length = 4;
    public Block type;
    public Rotation rotation;
    public int posX, posY;

    public int x(int blockNum) {
        return x(type, rotation, blockNum) + posX;
    }

    public int y(int blockNum) {
        return y(type, rotation, blockNum) + posY;
    }

    public void setMino(Block type, Rotation rotation, int posX, int posY) {
        this.type = type;
        this.rotation = rotation;
        this.posX = posX;
        this.posY = posY;
    }
    public void addXY(int x, int y) {
        this.posX += posX;
        this.posY += posY;
    }

    public static int x(Block type, Rotation rotation, int blockNum) {
        return allMinos[type.index][rotation.index][blockNum][0];
    }

    public static int y(Block type, Rotation rotation, int blockNum) {
        return allMinos[type.index][rotation.index][blockNum][1];
    }
    /**
     * Contains all pieces and their orientations
     * <pre>
     * {@code allMinos} - all orientations of all minos
     * {@code allMinos[a]} - all orientations of a single mino
     * {@code allMinos[a][b]} - a single orientation of a mino
     * {@code allMinos[a][b][c]} - the cartesian coordinates of a single block
     * {@code allMinos[a][b][c][d]} - the x[0] or y[1] coordinate of a block
     * </pre>
     * Minos, in order are: I,J,O,L,S,T,Z
     **/
    private static final int[][][][] allMinos = {
            {
                    {{0, 1}, {1, 1}, {2, 1}, {3, 1}},
                    {{1, 0}, {1, 1}, {1, 2}, {1, 3}},
                    {{0, 2}, {1, 2}, {2, 2}, {3, 2}},
                    {{2, 0}, {2, 1}, {2, 2}, {2, 3}}
            },
            {
                    {{0, 1}, {1, 1}, {2, 1}, {0, 0}},
                    {{1, 0}, {1, 1}, {1, 2}, {0, 2}},
                    {{0, 1}, {1, 1}, {2, 1}, {2, 2}},
                    {{1, 0}, {1, 1}, {1, 2}, {2, 0}}
            },
            {
                    {{1, 0}, {1, 1}, {2, 0}, {2, 1}},
                    {{1, 0}, {1, 1}, {2, 0}, {2, 1}},
                    {{1, 0}, {1, 1}, {2, 0}, {2, 1}},
                    {{1, 0}, {1, 1}, {2, 0}, {2, 1}}
            },
            {
                    {{0, 1}, {1, 1}, {2, 1}, {2, 0}},
                    {{1, 0}, {1, 1}, {1, 2}, {0, 0}},
                    {{0, 1}, {1, 1}, {2, 1}, {0, 2}},
                    {{1, 0}, {1, 1}, {1, 2}, {2, 2}}
            },
            {
                    {{1, 0}, {2, 0}, {0, 1}, {1, 1}},
                    {{0, 0}, {0, 1}, {1, 1}, {1, 2}},
                    {{1, 1}, {2, 1}, {0, 2}, {1, 2}},
                    {{1, 0}, {1, 1}, {2, 1}, {2, 2}}
            },
            {
                    {{1, 0}, {0, 1}, {1, 1}, {2, 1}},
                    {{1, 0}, {0, 1}, {1, 1}, {1, 2}},
                    {{0, 1}, {1, 1}, {2, 1}, {1, 2}},
                    {{1, 0}, {1, 1}, {2, 1}, {1, 2}}
            },
            {
                    {{0, 0}, {1, 0}, {1, 1}, {2, 1}},
                    {{1, 0}, {0, 1}, {1, 1}, {0, 2}},
                    {{0, 1}, {1, 1}, {1, 2}, {2, 2}},
                    {{2, 0}, {1, 1}, {2, 1}, {1, 2}}
            }
    };
}
