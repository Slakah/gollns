package com.gubbns.gollns;

import java.util.function.Predicate;

public class ReproductionRule implements Predicate<Integer> {
    @Override
    public boolean test(final Integer numAliveNeighbours) {
        return shouldCellBeReproduced(numAliveNeighbours);
    }

    private boolean shouldCellBeReproduced(final int numNeighbours) {
        return numNeighbours == 3;
    }
}
