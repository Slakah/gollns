package com.gubbns.gollns;


import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GameStepTest {
    @Test
    public void testSingleCellDies() {
        Set<XY> singleCell = new HashSet<>(Arrays.asList(XYPosition.ORIGIN.xy()));
        assertEquals(0, new GameStep(singleCell).step().size());
    }

    @Test
    public void testCellWithNeighbourDies() {
        Set<XY> singleCell = new HashSet<>(Arrays.asList(XYPosition.ORIGIN.xy(), XYPosition.TOP.xy()));
        assertEquals(0, new GameStep(singleCell).step().size());
    }

    @Test
    public void test2NeighbourCellsOneAlive() {
        Set<XY> cellsPreStep = new HashSet<>(Arrays.asList(XYPosition.ORIGIN.xy(), XYPosition.TOP.xy(), XYPosition.BOTTOM.xy()));
        Set<XY> cellsPostStep = new GameStep(cellsPreStep).step();
        assertThat(cellsPostStep, CoreMatchers.hasItems(XYPosition.ORIGIN.xy()));
        assertEquals(1, cellsPostStep.size());
    }

    @Test
    public void test4NeighbourCellsOriginOverpopulated() {
        Set<XY> cellsPreStep = new HashSet<>(Arrays.asList(XYPosition.ORIGIN.xy(), XYPosition.TOP.xy(), XYPosition.BOTTOM.xy(), XYPosition.LEFT.xy(), XYPosition.RIGHT.xy()));
        Set<XY> cellsPostStep = new GameStep(cellsPreStep).step();
        assertThat(cellsPostStep, CoreMatchers.hasItems(XYPosition.TOP.xy(), XYPosition.BOTTOM.xy(), XYPosition.LEFT.xy(), XYPosition.RIGHT.xy()));
        assertEquals(4, cellsPostStep.size());
    }

    @Test
    public void test4NeighbourCellsAndOneFarRightOriginAndRightOverpopulated() {
        Set<XY> cellsPreStep = new HashSet<>(Arrays.asList(XYPosition.ORIGIN.xy(), XYPosition.TOP.xy(), XYPosition.BOTTOM.xy(), XYPosition.LEFT.xy(), XYPosition.RIGHT.xy(), new XY(2, 0)));
        Set<XY> cellsPostStep = new GameStep(cellsPreStep).step();
        assertThat(cellsPostStep, CoreMatchers.hasItems(XYPosition.TOP.xy(), XYPosition.BOTTOM.xy(), XYPosition.LEFT.xy()));
        assertEquals(3, cellsPostStep.size());
    }

}
