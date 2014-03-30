package com.gubbns.gollns;


import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class GridTest {

    @Test
    public void testEmptyGridNoNeighbours() {
        final Grid emptyGrid = new Grid();
        assertEquals(0, emptyGrid.countAliveNeighbours(XY.origin()));
    }

    @Test
    public void testPopulatedGridNoNeighbours() {
        final Set<XY> cellsAwayFromOrigin = new HashSet<>(Arrays.<XY>asList(new XY(2, 3), new XY(7, 5)));
        final Grid grid = new Grid(cellsAwayFromOrigin);
        assertEquals(0, grid.countAliveNeighbours(XY.origin()));
    }

    @Test
    public void testSingleNeighbourTopRight() {
        final Set<XY> cellWithinOrigin = new HashSet<>(Arrays.asList(XYPosition.TOP_RIGHT.xy()));
        final Grid grid = new Grid(cellWithinOrigin);
        assertEquals(1, grid.countAliveNeighbours(XY.origin()));
    }

    @Test
    public void testSingleNeighbourRight() {
        final Set<XY> cellWithinOrigin = new HashSet<>(Arrays.asList(XYPosition.RIGHT.xy()));
        final Grid grid = new Grid(cellWithinOrigin);
        assertEquals(1, grid.countAliveNeighbours(XY.origin()));
    }

    @Test
    public void testSingleNeighbourBottomRight() {
        final Set<XY> cellWithinOrigin = new HashSet<>(Arrays.asList(XYPosition.BOTTOM_RIGHT.xy()));
        final Grid grid = new Grid(cellWithinOrigin);
        assertEquals(1, grid.countAliveNeighbours(XY.origin()));
    }


    @Test
    public void testTwoNeighbours() {
        final Set<XY> cellWithinOrigin = new HashSet<>(Arrays.asList(XYPosition.RIGHT.xy(), XYPosition.LEFT.xy()));
        final Grid grid = new Grid(cellWithinOrigin);
        assertEquals(2, grid.countAliveNeighbours(XY.origin()));
    }

    @Test
    public void testFindAliveCellsWith2NeighboursNonFound() {
        final Set<XY> cellWithinOrigin = new HashSet<>(Arrays.asList(XYPosition.ORIGIN.xy(), XYPosition.RIGHT.xy()));
        assertEquals(0, new Grid(cellWithinOrigin).findAliveCellsWithNeighbours(2).size());
    }


    @Test
    public void testFindAliveCellsWith2Neighbours() {
        final Set<XY> cellWithinOrigin = new HashSet<>(Arrays.asList(XYPosition.ORIGIN.xy(), XYPosition.RIGHT.xy(), XYPosition.LEFT.xy()));
        assertEquals(1, new Grid(cellWithinOrigin).findAliveCellsWithNeighbours(2).size());
        assertThat(new Grid(cellWithinOrigin).findAliveCellsWithNeighbours(2), hasItems(XYPosition.ORIGIN.xy()));
    }

    @Test
    public void testFindTwoAliveCellGroupsWith2Neighbours() {
        XY secondGroupOrigin = new XY(0, 20);
        final Set<XY> cellWithinOrigin = new HashSet<>(Arrays.asList(XYPosition.ORIGIN.xy(), XYPosition.RIGHT.xy(), XYPosition.LEFT.xy(),
                secondGroupOrigin, XYPosition.RIGHT.getNeighbourPos(secondGroupOrigin), XYPosition.LEFT.getNeighbourPos(secondGroupOrigin)));
        assertEquals(2, new Grid(cellWithinOrigin).findAliveCellsWithNeighbours(2).size());
        assertThat(new Grid(cellWithinOrigin).findAliveCellsWithNeighbours(2), hasItems(XYPosition.ORIGIN.xy(), secondGroupOrigin));
    }

}
