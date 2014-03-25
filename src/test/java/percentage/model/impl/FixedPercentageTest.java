package percentage.model.impl;

import org.junit.Test;
import percentage.model.Percentage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * To change this template use File | Settings | File Templates.
 *
 * @author "Simar Paul Singh"
 */
public class FixedPercentageTest {

    @Test
    public void testValidFixedPercentage() {
        final double percentageValue = 5d;
        final Percentage fixedPercentage = new FixedPercentage(percentageValue);
        assertEquals(percentageValue, fixedPercentage.getValue(), .01d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFixedPercentage() {
        final double invalidPercentageValue = -10d;
        new FixedPercentage(invalidPercentageValue);
        fail();
    }
}
