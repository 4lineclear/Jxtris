package main.java.game.gameModel;

//TODO: Rename a lot of these variable names to be more descriptive

/**
 * The piece that the user can control
 * <p> Made up of 4 cartesian coordinates </p>
 **/
class Mino {
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

    private static final BlockType[] allBlocks = BlockType.values();

    private BlockType type;
    private int rotation;
    /**
     * Initialize a {@link Mino} using a given number for the {@link Mino#type} and {@link Mino#rotation}
     * <pre>Given a number n, {@link Mino#type} can be:
     * 0 - {@link BlockType#I}
     * 1 - {@link BlockType#J}
     * 2 - {@link BlockType#O}
     * 3 - {@link BlockType#L}
     * 4 - {@link BlockType#S}
     * 5 - {@link BlockType#T}
     * 6 - {@link BlockType#Z} </pre>
     **/
    public Mino(int mino, int rotation) {
        this.type = allBlocks[mino];
        this.rotation = rotation;
    }
    public Mino(BlockType mino, int rotation){
        this.type = mino;
        this.rotation = rotation;
    }

    public int[][] getMinoCC() {
        return allMinos[type.ordinal()][rotation];
    }

    public BlockType getType(){
        return this.type;
    }
    public void setMino(int mino) {
        this.type = allBlocks[mino];
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
                "type=" + type +
                ", rotation=" + rotation +
                '}';
    }
}
