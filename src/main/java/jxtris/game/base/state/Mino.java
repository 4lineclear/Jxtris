package jxtris.game.base.state;

public class Mino {
    private final static MinoRepo minoRepo = new MinoRepo();

}

class MinoRepo{

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
    private final int[][][][] allMinos = {
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
    public int[][] getBlock(Block block, Rotation rotation){
        return this.allMinos[block.index][rotation.index];
    }
}