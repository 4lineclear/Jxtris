package main.java.game.gameModel;

//TODO: Rename a lot of these variable names to be more descriptive

/**
 * The piece that the user can control
 * <p> Made up of 4 cartesian coordinates </p>
 **/
public class Mino {
    /**
     * Contains all pieces and their orientations
     * <pre>
     * {@code allMinos} - all orientations of all minos
     * {@code allMinos[a]} - all orientations of a single mino
     * {@code allMinos[a][b]} - a single orientation of a mino
     * {@code allMinos[a][b][c]} - the cartesian coordinates of a single block
     * {@code allMinos[a][b][c][d]} - the x or y coordinate of a block
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

    private static final Block[] allBlocks = Block.values();

    private Block mino;
    private int rotation;

    public Mino(int mino, int rotation) {
        this.mino = allBlocks[mino];
        this.rotation = rotation;
    }
    public Mino(Block mino, int rotation){
        this.mino = mino;
        this.rotation = rotation;
    }

    public int[][] getMinoCC() {
        return allMinos[mino.ordinal()][rotation];
    }

    public Block getMino(){
        return this.mino;
    }
    public void setMino(int mino) {
        this.mino = allBlocks[mino];
    }
    public int getRotation(){
        return rotation;
    }
    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    @Override
    public String toString() {
        return "Mino{" +
                "mino=" + mino +
                ", rotation=" + rotation +
                '}';
    }
}
