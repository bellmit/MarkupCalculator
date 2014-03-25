package percentage.model.impl;

import org.junit.Test;
import percentage.model.Percentage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests fixed percentage model
 *
 * @author "Simar Paul Singh"
 */
public class FixedPercentageTest {

    /**
     * Tests creation of a valid fixed percentage
     */
    @Test
    public void testValidFixedPercentage() {
        final double percentageValue = 5d;
        final Percentage fixedPercentage = new FixedPercentage(percentageValue);
        assertEquals(percentageValue, fixedPercentage.getValue(), .01d);
    }

    /**
     * Tests exception on invalid (negative value) fixed percentage creation
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFixedPercentage() {
        final double invalidPercentageValue = -10d;
        new FixedPercentage(invalidPercentageValue);
        fail();
    }

    /**
     * Boundary Condition: Percentage with Zero values can be created. They are valid
     */
    @Test
    public void testZeroFixedPercentage() {
        assertEquals(0d, new FixedPercentage(0d).getValue(), 0d);
    }
}
