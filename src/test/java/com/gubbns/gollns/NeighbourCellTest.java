package com.gubbns.gollns;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NeighbourCellTest {
    private final XY origin = new XY(0, 0);

    @Test
    public void testTop() {
        assertEquals(new XY(0, 1), NeighbourCell.TOP.getNeighbourPos(origin));
    }

    @Test
    public void testTopRight() {
        assertEquals(new XY(1, 1), NeighbourCell.TOP_RIGHT.getNeighbourPos(origin));
    }

    @Test
    public void testRight() {
        assertEquals(new XY(1, 0), NeighbourCell.RIGHT.getNeighbourPos(origin));
    }

    @Test
    public void testBottomRight() {
        assertEquals(new XY(1, -1), NeighbourCell.BOTTOM_RIGHT.getNeighbourPos(origin));
    }

    @Test
    public void testBottom() {
        assertEquals(new XY(0, -1), NeighbourCell.BOTTOM.getNeighbourPos(origin));
    }

    @Test
    public void testBottomLeft() {
        assertEquals(new XY(-1, -1), NeighbourCell.BOTTOM_LEFT.getNeighbourPos(origin));
    }

    @Test
    public void testLeft() {
        assertEquals(new XY(-1, 0), NeighbourCell.LEFT.getNeighbourPos(origin));
    }

    @Test
    public void testTopLeft() {
        assertEquals(new XY(-1, 1), NeighbourCell.TOP_LEFT.getNeighbourPos(origin));
    }
}
