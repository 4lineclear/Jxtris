package org.jxtris.game.base;

import java.util.Iterator;

public record Mino(BlockType type, Rotation rotation) implements Iterable<Block> {

    @Override
    public Iterator<Block> iterator() {
        return new MinoIterator();
    }

    private final class MinoIterator implements Iterator<Block> {

        private int currentIndex = 0;

        private final Block[] blocks = MinoRepo.getMino(type,rotation);

        @Override
        public boolean hasNext() {
            return currentIndex < blocks.length && blocks[currentIndex] != null;
        }

        @Override
        public Block next() {
            return blocks[currentIndex++];
        }

    }
    private static final class MinoRepo {
        private static final Block[][][] allMinos = {
                {
                        {new Block(0, 1, BlockType.I), new Block(1, 1, BlockType.I), new Block(2, 1, BlockType.I), new Block(3, 1, BlockType.I)},
                        {new Block(1, 0, BlockType.I), new Block(1, 1, BlockType.I), new Block(1, 2, BlockType.I), new Block(1, 3, BlockType.I)},
                        {new Block(0, 2, BlockType.I), new Block(1, 2, BlockType.I), new Block(2, 2, BlockType.I), new Block(3, 2, BlockType.I)},
                        {new Block(2, 0, BlockType.I), new Block(2, 1, BlockType.I), new Block(2, 2, BlockType.I), new Block(2, 3, BlockType.I)}
                },
                {
                        {new Block(0, 1, BlockType.J), new Block(1, 1, BlockType.J), new Block(2, 1, BlockType.J), new Block(0, 0, BlockType.J)},
                        {new Block(1, 0, BlockType.J), new Block(1, 1, BlockType.J), new Block(1, 2, BlockType.J), new Block(0, 2, BlockType.J)},
                        {new Block(0, 1, BlockType.J), new Block(1, 1, BlockType.J), new Block(2, 1, BlockType.J), new Block(2, 2, BlockType.J)},
                        {new Block(1, 0, BlockType.J), new Block(1, 1, BlockType.J), new Block(1, 2, BlockType.J), new Block(2, 0, BlockType.J)}
                },
                {
                        {new Block(1, 0, BlockType.O), new Block(1, 1, BlockType.O), new Block(2, 0, BlockType.O), new Block(2, 1, BlockType.O)},
                        {new Block(1, 0, BlockType.O), new Block(1, 1, BlockType.O), new Block(2, 0, BlockType.O), new Block(2, 1, BlockType.O)},
                        {new Block(1, 0, BlockType.O), new Block(1, 1, BlockType.O), new Block(2, 0, BlockType.O), new Block(2, 1, BlockType.O)},
                        {new Block(1, 0, BlockType.O), new Block(1, 1, BlockType.O), new Block(2, 0, BlockType.O), new Block(2, 1, BlockType.O)}
                },
                {
                        {new Block(0, 1, BlockType.L), new Block(1, 1, BlockType.L), new Block(2, 1, BlockType.L), new Block(2, 0, BlockType.L)},
                        {new Block(1, 0, BlockType.L), new Block(1, 1, BlockType.L), new Block(1, 2, BlockType.L), new Block(0, 0, BlockType.L)},
                        {new Block(0, 1, BlockType.L), new Block(1, 1, BlockType.L), new Block(2, 1, BlockType.L), new Block(0, 2, BlockType.L)},
                        {new Block(1, 0, BlockType.L), new Block(1, 1, BlockType.L), new Block(1, 2, BlockType.L), new Block(2, 2, BlockType.L)}
                },
                {
                        {new Block(1, 0, BlockType.S), new Block(2, 0, BlockType.S), new Block(0, 1, BlockType.S), new Block(1, 1, BlockType.S)},
                        {new Block(0, 0, BlockType.S), new Block(0, 1, BlockType.S), new Block(1, 1, BlockType.S), new Block(1, 2, BlockType.S)},
                        {new Block(1, 1, BlockType.S), new Block(2, 1, BlockType.S), new Block(0, 2, BlockType.S), new Block(1, 2, BlockType.S)},
                        {new Block(1, 0, BlockType.S), new Block(1, 1, BlockType.S), new Block(2, 1, BlockType.S), new Block(2, 2, BlockType.S)}
                },
                {
                        {new Block(1, 0, BlockType.T), new Block(0, 1, BlockType.T), new Block(1, 1, BlockType.T), new Block(2, 1, BlockType.T)},
                        {new Block(1, 0, BlockType.T), new Block(0, 1, BlockType.T), new Block(1, 1, BlockType.T), new Block(1, 2, BlockType.T)},
                        {new Block(0, 1, BlockType.T), new Block(1, 1, BlockType.T), new Block(2, 1, BlockType.T), new Block(1, 2, BlockType.T)},
                        {new Block(1, 0, BlockType.T), new Block(1, 1, BlockType.T), new Block(2, 1, BlockType.T), new Block(1, 2, BlockType.T)}
                },
                {
                        {new Block(0, 0, BlockType.Z), new Block(1, 0, BlockType.Z), new Block(1, 1, BlockType.Z), new Block(2, 1, BlockType.Z)},
                        {new Block(1, 0, BlockType.Z), new Block(0, 1, BlockType.Z), new Block(1, 1, BlockType.Z), new Block(0, 2, BlockType.Z)},
                        {new Block(0, 1, BlockType.Z), new Block(1, 1, BlockType.Z), new Block(1, 2, BlockType.Z), new Block(2, 2, BlockType.Z)},
                        {new Block(2, 0, BlockType.Z), new Block(1, 1, BlockType.Z), new Block(2, 1, BlockType.Z), new Block(1, 2, BlockType.Z)}
                }
        };

        public static Block[] getMino(BlockType type, Rotation rotation) {
            return allMinos
                    [switch (type) {
                case I -> 0;
                case J -> 1;
                case O -> 2;
                case L -> 3;
                case S -> 4;
                case T -> 5;
                case Z -> 6;
                case X -> throw new IllegalStateException();
            }]
                    [switch (rotation) {
                case UP -> 0;
                case RIGHT -> 1;
                case LEFT -> 2;
                case DOWN -> 3;
            }];

        }
    }
}
