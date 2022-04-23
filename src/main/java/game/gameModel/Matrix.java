package main.java.game.gameModel;

public class Matrix {
    private final Block[][] board;
    public Matrix() {
        this.board = new Block[10][20];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                board[i][j] = Block.X;
            }
        }
    }
}
