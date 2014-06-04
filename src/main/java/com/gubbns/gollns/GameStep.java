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

        aliveCellsAfterStep.addAll(getCellsWhichSurvive(neighbourCounter));
        aliveCellsAfterStep.addAll(getReproductionCells(neighbourCounter));
        return aliveCellsAfterStep;
    }

    private Set<XY> getCellsWhichSurvive(final NeighbourCounter neighbourCounter) {
        return neighbourCounter.findAliveCellsWithNumNeighbours(2, 3);
    }

    private Set<XY> getReproductionCells(final NeighbourCounter neighbourCounter) {
        return neighbourCounter.findDeadCellsWithNumNeighbours(3);
    }

}
