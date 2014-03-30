package com.gubbns.gollns;

import java.util.*;
import java.util.stream.Collectors;

public class NeighbourCounter {
    private final Set<XY> aliveCells;

    public NeighbourCounter(Set<XY> aliveCells) {
        this.aliveCells = Collections.unmodifiableSet(aliveCells);
    }


    public Set<XY> findAliveCellsWithNumNeighbours(Integer... numNeighbours) {
        return findCellsWithNumNeighbours(CellState.ALIVE, numNeighbours);
    }

    public Set<XY> findDeadCellsWithNumNeighbours(Integer numNeighbours) {
        return findCellsWithNumNeighbours(CellState.DEAD, numNeighbours);
    }

    private Set<XY> findCellsWithNumNeighbours(CellState cellState, Integer... numNeighbours) {
        final Set<Integer> numNeighboursToMatch = new HashSet<>(Arrays.asList(numNeighbours));
        return getNeighbourCountMap().entrySet().stream()
                .filter(entry -> getCellState(entry.getKey()).equals(cellState))
                .filter(entry -> numNeighboursToMatch.contains(entry.getValue()))
                .map(Map.Entry<XY, Integer>::getKey)
                .collect(Collectors.toSet());
    }

    private CellState getCellState(XY cell) {
        return isCellAlive(cell) ? CellState.ALIVE : CellState.DEAD;
    }

    private boolean isCellAlive(XY cell) {
        return aliveCells.contains(cell);
    }


    private Map<XY, Integer> getNeighbourCountMap() {
        Map<XY, Integer> neighbourCountMap = new HashMap<>();
        for (XY cell : aliveCells) {
            addNeighbouringCellsCount(neighbourCountMap, cell);
        }
        return neighbourCountMap;
    }

    private Map<XY, Integer> addNeighbouringCellsCount(Map<XY, Integer> neighbourCountMap, XY originCell) {
        for (NeighbourCell neighbourCell : NeighbourCell.values()) {
            addNeighbourCount(neighbourCountMap, neighbourCell.getNeighbourPos(originCell));
        }
        return neighbourCountMap;
    }

    private Map<XY, Integer> addNeighbourCount(Map<XY, Integer> neighbourCountMap, XY neighbourCell) {
        Integer neighbourCount = neighbourCountMap.getOrDefault(neighbourCell, 0) + 1;
        neighbourCountMap.put(neighbourCell, neighbourCount);
        return neighbourCountMap;
    }
}
