package com.gubbns.gollns;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReproductionRuleTest {
    private final ReproductionRule reproductionRule = new ReproductionRule();

    @Test
    public void testTooFewNeighboursForReproduction() {
        assertFalse(reproductionRule.test(0));
        assertFalse(reproductionRule.test(1));
        assertFalse(reproductionRule.test(2));
    }

    @Test
    public void test3NeighboursReproduction() {
        assertTrue(reproductionRule.test(3));
    }

    @Test
    public void testTooManyNeighboursForReproduction() {
        assertFalse(reproductionRule.test(4));
        assertFalse(reproductionRule.test(5));
        assertFalse(reproductionRule.test(6));
        assertFalse(reproductionRule.test(7));
        assertFalse(reproductionRule.test(8));
    }
}
