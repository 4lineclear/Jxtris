package jxtris.game.base.state;

import jxtris.game.base.state.piece.Piece;

public abstract class BaseGame {
    private final Piece piece;
    private final Matrix matrix;

    protected BaseGame() {
        matrix = new Matrix();
        piece = new Piece(matrix::checkMino);
    }
    public void placeMino(){
        matrix.placeMino(piece.mino);
        piece.iterateMino();
    }
    public boolean move(int x, int y){
        piece.move(x,y);
        if(!matrix.checkMino(piece.mino)) {
            piece.move(-x, -y);
            return false;
        }
        return true;

    }
    public boolean canMove(int x, int y){
        if(!move(x, y))
            return false;
        piece.move(-x, -y);
        return true;
    }
    public void rotate(int direction){
        piece.rotateWhile(direction);
    }
    public void hold(){
        piece.hold();
    }
    public GameState getState(){
        return new GameState(
                piece.mino,
                piece.ghostMino.posY,
                piece.heldMino.held,
                piece.nextMinos.getNextMinos(),
                matrix.getRows()
        );
    }
}
