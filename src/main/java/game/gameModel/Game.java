package main.java.game.gameModel;

import java.util.*;

/**
 * The base game model of Jxtris
 **/
public class Game implements IGame {
    private final Matrix matrix;
    private final Queue<Mino> nextMinos;
    private Mino currMino, heldMino;
    private boolean held;
    private int x,y;
    /**
     * Tool to get the required offsets
     * <p>
     *     Is used to lessen the size of the {@link Matrix} and {@link Game} classes
     * </p>
     **/
    private final Offsets offsets;

    public Game() {
        matrix = new Matrix();
        offsets = new Offsets();
        nextMinos = new LinkedList<>();
        generateNextMinos();
        generateNextMinos();
        currMino = nextMinos.remove();
        heldMino = new Mino(BlockType.X,0);
        x = 3;
        y = 0;
        held = false;
        rotate(1);
        hardDrop();
        hardDrop();
        System.out.println(matrix);
    }

    @Override
    public void move(int x) {
        if(matrix.checkMino(currMino, this.x + x,  this.y)) {
            this.x += x;
        }
    }

    @Override
    public void rotate(int n) {
        if(currMino.getType() == BlockType.O) return;
        int[][] tests = offsets.get(currMino.getType(), currMino.getRotation(), n);
        for(int[] test : tests){
            if(rotationTest(test[0], test[1])){
                x += test[0];
                y += test[1];
                currMino.setRotation(n);
                break;
            }
        }
    }

    @Override
    public void softDrop(int n) {
        for(int i = n; matrix.checkMino(currMino, x, y); i++){
            y++;
        }
    }

    @Override
    public void hardDrop() {
        while(matrix.checkMino(currMino, x, y)){
            y++;
        }
        y--;
        placePiece();
    }

    @Override
    public void hold() {
        if(held)
            return;
        held = true;
        if(heldMino.getType() == BlockType.X){
            heldMino = currMino;
            iterateMino();
            return;
        }
        Mino temp = currMino;
        currMino = heldMino;
        heldMino = temp;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
    private boolean rotationTest(int testX, int testY){
        for(int[] block : currMino.getMinoCC()){
            if(matrix.checkMino(currMino, x + block[0] + testX,y + block[1] + testY)){
                return true;
            }
        }
        return false;
    }
    private void placePiece(){
        matrix.addMino(currMino,x,y);
        iterateMino();
        x = 3;
        y = 0;
        held = false;
    }
    private void iterateMino(){
        currMino = nextMinos.remove();
        if(nextMinos.size() < 8){
            generateNextMinos();
        }
    }
    private void generateNextMinos(){
        List<Mino> tempMinos = new ArrayList<>();
        for(int i = 0; i < 7; i++){
            tempMinos.add(new Mino(i,0));
        }
        Collections.shuffle(tempMinos);
        nextMinos.addAll(tempMinos);
    }
}
