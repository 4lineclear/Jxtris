package org.jxtris.game.model;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Manages the board the game is played on
 **/
class Matrix {
    /**
     * The board the game is played in
     * <pre>
     * {@code board} - All the blocks int he game
     * {@code board[a]} - A row of blocks
     * {@code board[a][b]} - A single block
     * </pre>
     **/
    private final BlockType[][] board;
    private final int[] rowCache;
    private final Queue<Integer> linesToClear;
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
        this.rowCache = new int[y];
        linesToClear = new ArrayDeque<>(4);
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                board[i][j] = BlockType.X;
            }
        }
    }

    public void addMino(Mino mino, int x, int y) {

        for (int[] block : mino.getMinoCC()) {
            int sumX = x + block[0], sumY = y + block[1];
            board[sumY][sumX] = mino.getType();
            rowCache[sumY] += 1;
            if (rowCache[sumY] > 9) linesToClear.add(sumY);
        }
        if (linesToClear.size() > 0) {
            while (!linesToClear.isEmpty()) {
                int row = linesToClear.remove();
                clearRow(row);
                rowCache[row] = 0;
            }
        }
    }

    private void clearRow(int clearPos) {
        for (int j = clearPos; j > 1; j--) {
            for (int i = x - 1; i >= 0; i--) {
                board[j][i] = board[j - 1][i];
            }
        }
    }

    /**
     * Checks if moving a mino in a given x and y is allowed
     * <p>
     * Given values should be after a given move
     * </p>
     *
     * @param mino The mino to be checked
     * @param x    The x direction to be at
     * @param y    The y direction to be at
     * @return Moved mino is within bounds, and free space({@link BlockType#X})
     * @see Matrix#checkMino(Mino, int, int)
     **/
    public boolean checkMino(Mino mino, int x, int y) {
        for (int[] block : mino.getMinoCC()) {
            int sumX = x + block[0], sumY = y + block[1];
            if (!matrixBound(sumX, sumY) || board[sumY][sumX] != BlockType.X) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if inputted numbers(x,y) are within the matrix's bounds
     * <p>
     * Uses {@link Matrix#x} and {@link Matrix#y}
     * </p>
     *
     * @param x The x vector to be checked
     * @param y The y vector to be checked
     * @return True if a coordinate can be found on {@link Matrix#board}(Meaning it's not out of bounds)
     **/
    private boolean matrixBound(int x, int y) {
        return x >= 0 && x < this.x && y >= 0 && y < this.y;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (BlockType[] row : board) {
            for (BlockType block : row) {
//                sb.append( block == BlockType.X ? " " : block.name());
                sb.append(block.name()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
