package com.gubbns.gollns;


import java.util.*;
import java.util.stream.Collectors;

public class Grid {
    private final Set<XY> aliveCells;

    public Grid() {
        this(Collections.<XY>emptySet());
    }

    public Grid(Set<XY> aliveCells) {
        this.aliveCells = Collections.unmodifiableSet(aliveCells);
    }

    public int countAliveNeighbours(XY cell) {
        int numNeighbours = 0;
        for (NeighbourCell neighbour : NeighbourCell.values()) {
            if (isCellAlive(neighbour.getNeighbourPos(cell))) {
                numNeighbours++;
            }
        }
        return numNeighbours;
    }


    private boolean isCellAlive(XY cell) {
        return aliveCells.contains(cell);
    }

    public Set<XY> findAliveCellsWithNeighbours(Integer... numNeighbours) {
        final Set<Integer> numNeighboursToMatch = new HashSet<>(Arrays.asList(numNeighbours));

        return getNeighbourCountMap().entrySet().stream()
                .filter(entry -> numNeighboursToMatch.contains(entry.getValue()))
                .map(Map.Entry<XY, Integer>::getKey)
                .collect(Collectors.toSet());
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
        if (isCellAlive(neighbourCell)) {
            Integer neighbourCount = neighbourCountMap.getOrDefault(neighbourCell, 0) + 1;
            neighbourCountMap.put(neighbourCell, neighbourCount);
        }
        return neighbourCountMap;
    }


}
