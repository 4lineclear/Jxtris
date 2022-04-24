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
        heldMino = new Mino(Block.X,0);
        x = 3;
        y = 0;
        held = false;
    }

    @Override
    public void move(int x) {
        if(matrix.checkMino(currMino, this.x + x,  this.y)) {
            this.x += x;
        }
    }

    @Override
    public void rotate(int n) {
        int[][] tests = offsets.get(currMino.getMino(), currMino.getRotation(), n);
    }

    @Override
    public void softDrop(int n) {
        for(int i = n; matrix.checkMino(currMino, x, y); i++){
            System.out.println(y);
            y++;
        }
    }

    @Override
    public void hardDrop() {
        while(matrix.checkMino(currMino, x, y)){
            System.out.println(y);
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
        if(heldMino.getMino() == Block.X){
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
