package com.gubbns.gollns;


import java.util.HashSet;
import java.util.Set;

public class GameStep {
    private final Set<XY> aliveCells;

    public GameStep(Set<XY> aliveCells) {
        this.aliveCells = aliveCells;
    }

    public Set<XY> step() {
        final NeighbourCounter neighbourCounter = new NeighbourCounter(aliveCells);
        final HashSet<XY> aliveCellsAfterStep = new HashSet<>();
        aliveCellsAfterStep.addAll(neighbourCounter.findAliveCellsWithNumNeighbours(2, 3));

        return aliveCellsAfterStep;
    }

}
