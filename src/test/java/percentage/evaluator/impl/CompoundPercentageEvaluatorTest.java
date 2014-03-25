package percentage.evaluator.impl;

import org.junit.BeforeClass;
import org.junit.Test;
import percentage.model.Percentage;
import percentage.model.impl.FixedPercentage;

import static org.junit.Assert.assertEquals;

/**
 * Tests compound percentage evaluator
 *
 * @author "Simar Paul Singh"
 */
public class CompoundPercentageEvaluatorTest {

    private static CompoundPercentageEvaluator compoundEvaluator;

    @BeforeClass
    public static void setUp() {
        compoundEvaluator = new CompoundPercentageEvaluator();
    }

    /**
     * Test compounding percentage evaluation
     * <p/>
     * 20%, 50% and 10% compounded over base value of 100 gives 198, which is a total of 98%
     */
    @Test
    public void testCompoundPercentageEvaluation() {
        final Percentage evaluatedPercentage = compoundEvaluator.evaluate(
                new FixedPercentage(20d), new FixedPercentage(50d), new FixedPercentage(10d));
        assertEquals(98d, evaluatedPercentage.getValue(), .01d);
    }

    /**
     * Test evaluation of base value, with percentages compounded
     */
    @Test
    public void testCompoundValueEvaluation() {
        final double baseValue = 100d;
        final double evaluatedValue = compoundEvaluator.compound(
                baseValue, new FixedPercentage(20d), new FixedPercentage(50d), new FixedPercentage(10d));
        assertEquals(198d, evaluatedValue, .01d);
    }

    /**
     * Test compounding evaluation with negative base value (sign preservation)
     */
    @Test
    public void testNegativeBaseValueEvaluation() {
        final double baseValue = -2000d;
        final double evaluatedValue = compoundEvaluator.compound(
                baseValue, new FixedPercentage(20d), new FixedPercentage(50d), new FixedPercentage(10d));
        assertEquals(-3960d, evaluatedValue, .01d);
    }

    /**
     * Boundary Condition: Tests evaluation with zero base value (should evaluate to zero)
     */
    @Test
    public void testZeroBaseValueEvaluation() {
        final double evaluatedValue = compoundEvaluator.compound(0d,
                new FixedPercentage(Math.abs(Math.random()) * 100),
                new FixedPercentage(Math.abs(Math.random()) * 100));
        assertEquals(0d, evaluatedValue, .00d);
    }

    /**
     * Boundary Condition: Tess evaluation with empty or zero percentage(s)
     */
    @Test
    public void testZeroPercentageEvaluation() {
        final double baseValue = Math.random() * 1000;
        final double evaluatedValue = compoundEvaluator.compound(baseValue,
                new FixedPercentage(0d),
                new FixedPercentage(0d));
        assertEquals(baseValue, evaluatedValue, .01d);
        assertEquals(baseValue, compoundEvaluator.compound(baseValue), .00d);

    }
}
