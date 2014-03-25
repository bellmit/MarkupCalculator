package percentage.evaluator.impl;

import org.junit.BeforeClass;
import org.junit.Test;
import percentage.model.Percentage;
import percentage.model.impl.FixedPercentage;

import static org.junit.Assert.assertEquals;

/**
 * Tests Simple Percentage Evaluator
 *
 * @author "Simar Paul Singh"
 */
public class SimplePercentageEvaluatorTest {

    private static SimplePercentageEvaluator simpleEvaluator;

    @BeforeClass
    public static void setUp() {
        simpleEvaluator = new SimplePercentageEvaluator();
    }

    /**
     * Tests Simple Percentage Evaluation
     */
    @Test
    public void testSimplePercentageEvaluation() {
        final Percentage evaluatedPercentage = simpleEvaluator.evaluate(
                new FixedPercentage(10d),
                new FixedPercentage(15d),
                new FixedPercentage(25.50d),
                new FixedPercentage(30.75d));
        assertEquals((10d + 15d + 25.50d + 30.75d), evaluatedPercentage.getValue(), .01d);
    }

    /**
     * Test evaluation of base value with percentages in simple
     */
    @Test
    public void testSimpleValueEvaluation() {
        final double baseValue = 100d;
        final double evaluatedValue = simpleEvaluator.simple(baseValue,
                new FixedPercentage(10d), new FixedPercentage(20d));
        assertEquals(130d, evaluatedValue, .01d);
    }

    /**
     * Tests evaluation with negative base value (sign preserved)
     */
    @Test
    public void testSimpleNegativeValueEvaluation() {
        final double baseValue = -100d;
        final double evaluatedValue = simpleEvaluator.simple(baseValue,
                new FixedPercentage(10d), new FixedPercentage(20d));
        assertEquals(-130d, evaluatedValue, .01d);
    }

    /**
     * Boundary Condition: Test with empty and or Zero Percentages
     */
    @Test
    public void testEmptyEvaluation() {
        final double baseValue = 10d;
        final double evaluatedValue = simpleEvaluator.simple(baseValue);
        assertEquals(baseValue, evaluatedValue, .01d);
        assertEquals(baseValue, simpleEvaluator.simple(baseValue, new FixedPercentage(0d), new FixedPercentage(0d)), .01d);
    }

    /**
     * Boundary Condition: Test with Zero Base Value
     */
    @Test
    public void testZeroBaseValueEvaluation() {
        final double baseValue = 0d;
        final double evaluatedValue = simpleEvaluator.simple(baseValue, new FixedPercentage(3d), new FixedPercentage(5d));
        assertEquals(baseValue, evaluatedValue, 0d);
    }

}
