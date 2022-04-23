package main.java.game.gameModel;

import java.util.*;

/**
 * The base game model of Jxtris
 **/
public class Game implements IGame {
    private final Matrix matrix;
    private final Queue<Mino> nextMinos;
    private int X,Y;

    public Game() {
        matrix = new Matrix();
        nextMinos = new LinkedList<>();
        generateNextMinos();
        generateNextMinos();
    }

    @Override
    public void move(int n) {

    }

    @Override
    public void rotate(int n) {

    }

    @Override
    public void softDrop(int n) {

    }

    @Override
    public void hardDrop() {

    }

    @Override
    public void hold() {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

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
