package org.jxtris.game.model;

import java.util.*;

/**
 * The base game model of Jxtris
 **/
public class Game {
    /**
     * The board the game is on
     **/
    private final Matrix matrix;
    /**
     * Queue holding the next pieces
     * <p>
     * 7 pieces are added when there are less than 8 left
     * </p>
     *
     * @see Game#iterateMino()
     **/
    private final Queue<Mino> nextMinos;
    /**
     * Tool to get the required offsets
     * <p>
     * Is used to lessen the size of the {@link Matrix} and {@link Game} classes
     * </p>
     **/
    private final Offsets offsets;
    /**
     * The mino currently on the board, is not actually put onto the {@link Game#matrix}
     * <p>
     * More is put onto the {@link Game#matrix} when it is placed
     * </p>
     **/
    private Mino currMino;
    /**
     * The mino currently held
     *
     * @see Game#hold()
     **/
    private Mino heldMino;
    /**
     * Stores whether the currently held mino has been recently held(before placing another block)
     * <p>
     * Stops the user from repeatedly holding to gain more time
     * </p>
     **/
    private boolean held;
    /**
     * Coordinate for the current piece
     **/
    private int x, y;

    /**
     * Game's constructor
     * <p>
     * Need to move some of the things here into {@link Game#start()}
     * </p>
     **/
    public Game() {
        matrix = new Matrix();
        offsets = new Offsets();
        nextMinos = new ArrayDeque<>();
        generateNextMinos();
        generateNextMinos();
        currMino = nextMinos.remove();
        heldMino = new Mino(BlockType.X, 0);
        x = 3;
        y = 0;
        held = false;
////        Small test
//        currMino = new Mino(0,0);
//        move(-3);
//        hardDrop();
//        currMino = new Mino(0,0);
//        move(1);
//        hardDrop();
//        currMino = new Mino(2,0);
//        move(4);
//        hardDrop();
//        iterateMino();
//        hardDrop();
//        hardDrop();
//        System.out.println(matrix);
    }


    /**
     * Move the current piece an n number of blocks
     *
     * @param x The number of movements, and direction
     **/
    public void move(int x) {
        if (matrix.checkMino(currMino, this.x + x, this.y)) {
            this.x += x;
        }
    }

    /**
     * Rotate the current piece an n number of blocks
     *
     * @param n The number of rotations, and direction
     **/
    public void rotate(int n) {
        if (currMino.getType() == BlockType.O) return;
        int[][] tests = offsets.get(currMino.getType(), currMino.getRotation(), n);
        for (int[] test : tests) {
            if (rotationTest(test[0], test[1], n)) {
                x += test[0];
                y += test[1];
                currMino.setRotation(n);
                break;
            }
        }
    }

    /**
     * Drop the current piece an n number of blocks
     *
     * @param n The number of blocks to move down
     **/
    public void softDrop(int n) {
        for (int i = 0; matrix.checkMino(currMino, x, y + 1) && i < n; i++) {
            y++;
        }
    }

    public void hardDrop() {
        while (matrix.checkMino(currMino, x, y + 1)) {
            y++;
        }
        placePiece();
    }

    public void hold() {
        if (held)
            return;
        held = true;
        if (heldMino.getType() == BlockType.X) {
            heldMino = currMino;
            iterateMino();
            return;
        }
        Mino temp = currMino;
        currMino = heldMino;
        heldMino = temp;
    }

    public void start() {
        throw new RuntimeException("start not implemented yet");
    }

    public void stop() {
        throw new RuntimeException("stop not implemented yet");
    }

    public void restart() {
        throw new RuntimeException("restart not implemented yet");
    }

    /**
     * Tests whether a rotation is valid or not
     * <p>
     * Uses {@link Mino#getRotated(int)} to check if a certain rotation is valid
     * </p>
     *
     * @param n     The rotation to check
     * @param testX The offset int the x to check
     * @param testY The offset int the y to check
     * @return True if a rotation is valid, false if it isn't
     **/
    private boolean rotationTest(int testX, int testY, int n) {
        for (int[] block : currMino.getRotated(n)) {
            if (matrix.checkMino(currMino, x + block[0] + testX, y + block[1] + testY)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Places the current piece onto the board
     * <p>
     * Then iterates to the next piece
     * </p>
     * Finally, resets {@link Game#x}, {@link Game#y} and {@link Game#held} to their starting values (3, 0, false)
     **/
    private void placePiece() {
        matrix.addMino(currMino, x, y);
        iterateMino();
        x = 3;
        y = 0;
        held = false;
    }

    /**
     * Iterates the mino, removing the first in of {@link Game#nextMinos}
     * <p>
     * If {@link Game#nextMinos} size is less than 8, calls {@link Game#generateNextMinos()}
     * </p>
     **/
    private void iterateMino() {
        currMino = nextMinos.remove();
        if (nextMinos.size() < 8) {
            generateNextMinos();
        }
    }

    /**
     * Generates a bag of 7 randomly ordered standard (I,J,O,L,S,T,Z) and adds them to {@link Game#nextMinos}
     **/
    private void generateNextMinos() {
        List<Mino> tempMinos = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            tempMinos.add(new Mino(i, 0));
        }
        Collections.shuffle(tempMinos);
        nextMinos.addAll(tempMinos);
    }
}
