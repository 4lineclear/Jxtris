package main.java.game.gameModel;

public class Matrix {
    public final Block[][] board;

    public Matrix() {
        this.board = new Block[20][10];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = Block.X;
            }
        }
    }
    public void addPiece(Mino mino, int position){
        for(int[] block : mino.getPiece()){
            board[block[1]][block[0]] = mino.getBlock();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Block[] row : board) {
            for (Block block : row) {
                sb.append(block.name()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
