package com.gubbns.gollns;


import java.util.HashSet;
import java.util.Set;

public class GameStep {
    private final Set<XY> aliveCells;

    public GameStep(Set<XY> aliveCells) {
        this.aliveCells = aliveCells;
    }

    public Set<XY> step() {
        final Grid grid = new Grid(aliveCells);
        final HashSet<XY> aliveCellsAfterStep = new HashSet<>();
        aliveCellsAfterStep.addAll(grid.findAliveCellsWithNeighbours(2, 3));

        return aliveCellsAfterStep;
    }

    private boolean shouldCellBeDeadAfterStep(final Grid grid, final XY cell) {
        final LifeRule lifeRule = new LifeRule();
        final int numAliveNeighbours = grid.countAliveNeighbours(cell);
        return lifeRule.test(numAliveNeighbours);
    }
}
