package com.gubbns.gollns;


import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.gubbns.gollns.XYPosition.*;
import static org.junit.Assert.assertEquals;

public class GameStepTest {
    @Test
    public void testSingleCellDies() {
        Set<XY> singleCell = new HashSet<>(Arrays.asList(ORIGIN.xy()));
        assertEquals(0, new GameStep(singleCell).step().size());
    }

    @Test
    public void test2CellGroupDies() {
        Set<XY> singleCell = new HashSet<>(Arrays.asList(ORIGIN.xy(), TOP.xy()));
        assertEquals(0, new GameStep(singleCell).step().size());
    }

    @Test
    public void test4CellBlockStill() {
        Set<XY> block = new HashSet<>(Arrays.asList(ORIGIN.xy(), RIGHT.xy(), BOTTOM_RIGHT.xy(), BOTTOM.xy()));
        assertEquals(block, new GameStep(block).step());
    }

    @Test
    public void testPlusSymbolToSquareStep() {
        Set<XY> plusSymbol = new HashSet<>(Arrays.asList(ORIGIN.xy(), TOP.xy(), BOTTOM.xy(), LEFT.xy(), RIGHT.xy()));
        Set<XY> square = new HashSet<>(Arrays.asList(TOP.xy(), BOTTOM.xy(), LEFT.xy(), RIGHT.xy(), TOP_RIGHT.xy(), BOTTOM_RIGHT.xy(), BOTTOM_LEFT.xy(), TOP_LEFT.xy()));
        assertEquals(square, new GameStep(plusSymbol).step());
    }

    @Test
    public void testHorizontalLineToVerticalLineStep() {
        Set<XY> horizontalLine = new HashSet<>(Arrays.asList(ORIGIN.xy(), LEFT.xy(), RIGHT.xy()));
        Set<XY> verticalLine = new HashSet<>(Arrays.asList(ORIGIN.xy(), TOP.xy(), BOTTOM.xy()));
        assertEquals(verticalLine, new GameStep(horizontalLine).step());
    }

}
