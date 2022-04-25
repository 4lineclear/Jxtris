package main.java.game.gameModel;

/**
 * The template for the Jxtris game
 * <p>
 *     Intended to work without the knowledge of a GUI, and can simply be plugged into
 * </p>
 **/
public interface IGame {
    /**
     * Move the current piece an n number of blocks
     *
     * @param x The number of movements, and direction
     **/
    void move(int x);

    /**
     * Rotate the current piece an n number of blocks
     *
     * @param n The number of rotations, and direction
     **/
    void rotate(int n);

    /**
     * Drop the current piece an n number of blocks
     *
     * @param n The number of blocks to move down
     **/
    void softDrop(int n);

    /**
     * Drop the current piece until it hits the lowest it can
     **/
    void hardDrop();

    /**
     * Hold the current piece
     **/
    void hold();

    /**
     * Start the game
     **/
    void start();

    /**
     * Stop the game
     **/
    void stop();

}
