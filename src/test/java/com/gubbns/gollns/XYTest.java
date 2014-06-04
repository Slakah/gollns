package com.gubbns.gollns;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class XYTest {
    @Test
    public void testEqualPositionCellsAreEqual() {
        assertThat(new XY(0, 0), equalTo(new XY(0, 0)));
        assertThat(new XY(0, 1), equalTo(new XY(0, 1)));
    }

    @Test
    public void testDifferentPositionsCellsAreNotEqual() {
        assertThat(new XY(0, 0), not(equalTo(new XY(0, 1))));
        assertThat(new XY(0, 0), not(equalTo(new XY(0, 1))));
    }

}
