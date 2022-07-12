package jxtris.game.base.state;

import java.util.Queue;

public record State(Mino mino, Block heldMino, Queue<Block> nextMinos, Line[] rows){

}
