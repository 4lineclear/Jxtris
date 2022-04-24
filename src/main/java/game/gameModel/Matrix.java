package main.java.game.gameModel;

public class Matrix {
    /**
     * The board the game is played in
     * <pre>
     * {@code board} - All the blocks int he game
     * {@code board[a]} - A row of blocks
     * {@code board[a][b]} - A single block
     * </pre>
     **/
    private final BlockType[][] board;
    /**
     * The number of columns of the {@link Matrix#board}
     **/
    private final int x;
    /**
     * The number of rows of the {@link Matrix#board}
     **/
    private final int y;

    public Matrix() {
        x = 10;
        y = 20;
        this.board = new BlockType[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                board[i][j] = BlockType.X;
            }
        }
    }
    public void addMino(Mino mino, int x, int y){
        for(int[] block : mino.getMinoCC()){
            board[y + block[1]][x + block[0]] = mino.getType();
        }
    }
    /**
     * Checks if moving a mino in a given x and y is allowed
     * <p>
     *     Given values should be after a given move
     * </p>
     * @param mino The mino to be checked
     * @param x The x direction to be at
     * @param y The y direction to be at
     * @return Moved mino is within bounds, and free space({@link BlockType#X})
     * @see Matrix#checkMino(Mino, int, int)
     **/
    public boolean checkMino(Mino mino, int x, int y){
        for(int[] block : mino.getMinoCC()){
            int sumX = x + block[0], sumY = y + block[1];
            if(!matrixBound(sumX, sumY) || board[sumY][sumX] != BlockType.X) {
                return false;
            }
        }
        return true;
    }
    /**
     * Checks if inputted numbers(x,y) are within the matrix's bounds
     * <p>
     *     Uses {@link Matrix#x} and {@link Matrix#y}
     * </p>
     * @param x The x vector to be checked
     * @param y The y vector to be checked
     * @return True if a coordinate can be found on {@link Matrix#board}
     **/
    private boolean matrixBound(int x, int y){
        return x > 0 && x < this.x && y >=0 && y < this.y;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (BlockType[] row : board) {
            for (BlockType block : row) {
                sb.append(block.name()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
