package com.gubbns.gollns;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LifeRuleTest {
    private final LifeRule lifeRule = new LifeRule();

    @Test
    public void testUnderpopulation() {
        assertFalse(lifeRule.test(0));
        assertFalse(lifeRule.test(1));
    }

    @Test
    public void testOverpopulation() {
        assertFalse(lifeRule.test(4));
        assertFalse(lifeRule.test(5));
        assertFalse(lifeRule.test(6));
        assertFalse(lifeRule.test(7));
        assertFalse(lifeRule.test(8));
    }

    @Test
    public void testAdequatePopulation() {
        assertTrue(lifeRule.test(2));
        assertTrue(lifeRule.test(3));
    }
}
