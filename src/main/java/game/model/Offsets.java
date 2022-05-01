package main.java.game.model;

import java.util.HashMap;

class Offsets {
    private final HashMap<Integer, int[][]> offsets, offsetsI, offsets180;

    public Offsets() {
        offsets = new HashMap<>();
        offsetsI = new HashMap<>();
        offsets180 = new HashMap<>();
        /*
        Structured as:
        offsets[a] - returns a set of tests for a given combination of previous and next rotations
        offsets[a][b] - returns a test based on [a] and the test number
        offsets[a][b][c] - returns the x or y offset to apply
         */
        final int[][][] offsetsArr = {
                {{0, 0}, {+1, 0}, {+1, -1}, {0, +2}, {+1, +2}},
                {{0, 0}, {-1, 0}, {-1, +1}, {0, -2}, {-1, -2}},
                {{0, 0}, {-1, 0}, {-1, +1}, {0, -2}, {-1, -2}},
                {{0, 0}, {+1, 0}, {+1, -1}, {0, +2}, {+1, +2}},
                {{0, 0}, {-1, 0}, {-1, -1}, {0, +2}, {-1, +2}},
                {{0, 0}, {+1, 0}, {+1, +1}, {0, -2}, {+1, -2}},
                {{0, 0}, {+1, 0}, {+1, +1}, {0, -2}, {+1, -2}},
                {{0, 0}, {-1, 0}, {-1, -1}, {0, +2}, {-1, +2}}
        };

        final int[][][] offsetsIArr = {
                {{0, 0}, {+2, 0}, {-1, 0}, {+2, -1}, {-1, +2}},
                {{0, 0}, {-2, 0}, {+1, 0}, {-2, +1}, {+1, -2}},
                {{0, 0}, {+1, 0}, {-2, 0}, {+1, +2}, {-2, -1}},
                {{0, 0}, {-1, 0}, {+2, 0}, {-1, -2}, {+2, +1}},
                {{0, 0}, {-2, 0}, {+1, 0}, {-2, +1}, {+1, -2}},
                {{0, 0}, {+2, 0}, {-1, 0}, {+2, -1}, {-1, +2}},
                {{0, 0}, {-1, 0}, {+2, 0}, {-1, -2}, {+2, +1}},
                {{0, 0}, {+1, 0}, {-2, 0}, {+1, +2}, {-2, -1}}
        };
        final int[][][] offsets180Arr = {
                {{0, 0}, {0, -1}, {-1, -1}, {+1, -1}, {-1, 0}, {+1, 0}},
                {{0, 0}, {0, +1}, {+1, +1}, {-1, +1}, {+1, 0}, {-1, 0}},
                {{0, 0}, {-1, 0}, {-1, -2}, {-1, -1}, {0, -2}, {0, -1}},
                {{0, 0}, {+1, 0}, {+1, -2}, {+1, -1}, {0, -2}, {0, -1}}
        };
        //Note: These keys should NOT be changed,
        //unless changing the system used to save
        //mino orientation
        int[] keys = {1, 10, 12, 21, 23, 32, 30, 3};
        int[] keys180 = {2, 20, 13, 31};
        for (int i = 0; i < 8; i++) {
            offsets.put(keys[i], offsetsArr[i]);
            offsetsI.put(keys[i], offsetsIArr[i]);
            if (i < 4) offsets180.put(keys180[i], offsets180Arr[i]);
        }
    }
    //TODO: Redo a ton of this shit, its all wack

    /**
     * Returns the offsets needed as an int array
     * <pre>
     * First, evaluate whether the difference between from and to is |2|
     * If it is, pull from {@link Offsets#offsets180}
     * Else, evaluated if the block being check is {@link BlockType#I}
     * If it is, pull from {@link Offsets#offsetsI}
     * Else, pull from {@link Offsets#offsets}
     * </pre>
     * {@code final int key = from * 10 + to}
     *
     * @param type The type of Mino being checked
     * @param from The current rotation of the current mino
     * @param to   The rotation to be checked
     * @return An {@code int[][]}
     **/
    public int[][] get(BlockType type, int from, int to) {
        final int key = from * 10 + to;
        return (from - to == 2 || from - to == -2 ?
                offsets180 :
                type == BlockType.I ?
                        offsetsI :
                        offsets)
                .get(key);
    }
}
