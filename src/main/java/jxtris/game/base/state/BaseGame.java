package jxtris.game.base.state;

import jxtris.game.base.state.piece.Piece;

public abstract class BaseGame {
    private final Piece piece;
    private final Matrix matrix;

    protected BaseGame() {
        matrix = new Matrix();
        piece = new Piece();
    }
    private void placeMino(){
        matrix.placeMino(piece.iterateMino());
    }
    public void move(int x, int y){
        piece.move(x,y);
        if(!matrix.checkMino(piece.mino))
            piece.move(-x,-y);
    }
    public void rotate(int direction){
        piece.rotateWhile(direction, matrix::checkMino);
    }
    public void hold(){
        piece.hold();
    }
    public GameState getState(){
        return new GameState(
                piece.mino.type,
                piece.mino.rotation,
                piece.mino.posX,
                piece.mino.posY,
                piece.heldMino.held,
                piece.nextMinos.getNextMinos(),
                matrix.getRows()
        );
    }
}
