package jxtris.game.base.state;

import java.util.HashMap;

public class Offsets extends HashMap<Integer, int[][]> {

    public Offsets() {
        /*
        Structured as:
        offsets[a] - returns a set of tests for a given combination of previous and next rotations
        offsets[a][b] - returns a test based on [a] and the test number
        offsets[a][b][c] - returns the x or y offset to apply
         */
        final int[][][] offsets = {
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
        for (int i = 0; i < 20; i++) {
            this.put(keys[i], offsets[i]);
        }
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
        if(type == Block.I && diff != 2 && diff != -2)
            key *=-1;
        return this.get(key);
    }
}