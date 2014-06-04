package com.gubbns.gollns;

import java.util.function.Predicate;

public class LifeRule implements Predicate<Integer> {

    @Override
    public boolean test(Integer numAliveNeighbours) {
        return shouldCellBeAlive(numAliveNeighbours);
    }

    private boolean shouldCellBeAlive(final int numAliveNeighbours) {
        return numAliveNeighbours == 2 || numAliveNeighbours == 3;
    }
}
