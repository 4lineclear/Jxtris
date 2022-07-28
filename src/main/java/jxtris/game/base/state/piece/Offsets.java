package jxtris.game.base.state.piece;

import jxtris.game.base.state.Block;
import jxtris.game.base.state.Rotation;

import java.util.HashMap;

public class Offsets {
    private final HashMap<Integer, int[][]> offsets;

    public Offsets() {
        offsets = new HashMap<>();
        /*
        Structured as:
        offsetsArr[a] - returns a set of tests for a given combination of previous and next rotations
        offsetsArr[a][b] - returns a test based on [a] and the test number
        offsetsArr[a][b][c] - returns the x or y offset to apply
         */
        final int[][][] offsetsArr = {
                {{0, 0}, {+1, 0}, {+1, -1}, {0, +2}, {+1, +2}},
                {{0, 0}, {-1, 0}, {-1, +1}, {0, -2}, {-1, -2}},
                {{0, 0}, {-1, 0}, {-1, +1}, {0, -2}, {-1, -2}},
                {{0, 0}, {+1, 0}, {+1, -1}, {0, +2}, {+1, +2}},
                {{0, 0}, {-1, 0}, {-1, -1}, {0, +2}, {-1, +2}},
                {{0, 0}, {+1, 0}, {+1, +1}, {0, -2}, {+1, -2}},
                {{0, 0}, {+1, 0}, {+1, +1}, {0, -2}, {+1, -2}},
                {{0, 0}, {-1, 0}, {-1, -1}, {0, +2}, {-1, +2}},

                {{0, 0}, {+2, 0}, {-1, 0}, {+2, -1}, {-1, +2}},//I
                {{0, 0}, {-2, 0}, {+1, 0}, {-2, +1}, {+1, -2}},
                {{0, 0}, {+1, 0}, {-2, 0}, {+1, +2}, {-2, -1}},
                {{0, 0}, {-1, 0}, {+2, 0}, {-1, -2}, {+2, +1}},
                {{0, 0}, {-2, 0}, {+1, 0}, {-2, +1}, {+1, -2}},
                {{0, 0}, {+2, 0}, {-1, 0}, {+2, -1}, {-1, +2}},
                {{0, 0}, {-1, 0}, {+2, 0}, {-1, -2}, {+2, +1}},
                {{0, 0}, {+1, 0}, {-2, 0}, {+1, +2}, {-2, -1}},

                {{0, 0}, {0, -1}, {-1, -1}, {+1, -1}, {-1, 0}, {+1, 0}},//180
                {{0, 0}, {0, +1}, {+1, +1}, {-1, +1}, {+1, 0}, {-1, 0}},
                {{0, 0}, {-1, 0}, {-1, -2}, {-1, -1}, {0, -2}, {0, -1}},
                {{0, 0}, {+1, 0}, {+1, -2}, {+1, -1}, {0, -2}, {0, -1}}
        };

        int[] keys = {
                1, 10, 12, 21, 23, 32, 30, 3,
                -1, -10, -12, -21, -23, -32, -30, -3,
                2, 20, 13, 31
        };
        for (int i = 0; i < 20; i++)
            this.offsets.put(keys[i], offsetsArr[i]);

    }

    /**
     * Returns the offsets needed as an int array
     *
     * @param type The type of Mino being checked
     * @param from The current rotation of the current mino
     * @param to   The rotation to be checked
     * @return An {@code int[][]}
     **/
    public int[][] get(Block type, Rotation from, Rotation to) {
        int key = from.index * 10 + to.index;
        int diff = from.index - to.index;
        if (type == Block.I && diff != 2 && diff != -2)
            key *= -1;
//        System.out.println(Arrays.deepToString(this.offsets.get(key)));
        System.out.println(key);
        return this.offsets.get(key);
    }
}