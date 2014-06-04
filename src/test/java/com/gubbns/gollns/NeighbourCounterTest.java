package com.gubbns.gollns;


import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class NeighbourCounterTest {
    @Test
    public void testFindAliveCellsWith2NeighboursNonFound() {
        final Set<XY> cellWithinOrigin = new HashSet<>(Arrays.asList(XYPosition.ORIGIN.xy(), XYPosition.RIGHT.xy()));
        assertEquals(0, new NeighbourCounter(cellWithinOrigin).findAliveCellsWithNumNeighbours(2).size());
    }


    @Test
    public void testFindAliveCellsWith2Neighbours() {
        final Set<XY> cellWithinOrigin = new HashSet<>(Arrays.asList(XYPosition.ORIGIN.xy(), XYPosition.RIGHT.xy(), XYPosition.LEFT.xy()));
        assertEquals(1, new NeighbourCounter(cellWithinOrigin).findAliveCellsWithNumNeighbours(2).size());
        assertThat(new NeighbourCounter(cellWithinOrigin).findAliveCellsWithNumNeighbours(2), hasItems(XYPosition.ORIGIN.xy()));
    }

    @Test
    public void testFindTwoAliveCellGroupsWith2Neighbours() {
        XY secondGroupOrigin = new XY(0, 20);
        final Set<XY> cellWithinOrigin = new HashSet<>(Arrays.asList(XYPosition.ORIGIN.xy(), XYPosition.RIGHT.xy(), XYPosition.LEFT.xy(),
                secondGroupOrigin, XYPosition.RIGHT.getNeighbourPos(secondGroupOrigin), XYPosition.LEFT.getNeighbourPos(secondGroupOrigin)));
        assertEquals(2, new NeighbourCounter(cellWithinOrigin).findAliveCellsWithNumNeighbours(2).size());
        assertThat(new NeighbourCounter(cellWithinOrigin).findAliveCellsWithNumNeighbours(2), hasItems(XYPosition.ORIGIN.xy(), secondGroupOrigin));
    }

    @Test
    public void testFindNoDeadCellsWith3Neighbours() {
        final Set<XY> cellWithinOrigin = new HashSet<>(Arrays.asList(XYPosition.ORIGIN.xy(), XYPosition.RIGHT.xy()));
        assertEquals(0, new NeighbourCounter(cellWithinOrigin).findDeadCellsWithNumNeighbours(3).size());
    }

    @Test
    public void testFindTopRightDeadCellsWith3Neighbours() {
        final Set<XY> cellWithinOrigin = new HashSet<>(Arrays.asList(XYPosition.ORIGIN.xy(), XYPosition.RIGHT.xy(), XYPosition.TOP.xy()));
        assertEquals(1, new NeighbourCounter(cellWithinOrigin).findDeadCellsWithNumNeighbours(3).size());
        assertThat(new NeighbourCounter(cellWithinOrigin).findDeadCellsWithNumNeighbours(3), hasItems(XYPosition.TOP_RIGHT.xy()));

    }
}
