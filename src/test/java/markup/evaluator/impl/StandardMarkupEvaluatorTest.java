package markup.evaluator.impl;

import markup.evaluator.MarkupEvaluator;
import markup.model.impl.Markups;
import org.junit.BeforeClass;
import org.junit.Test;
import percentage.evaluator.impl.CompoundPercentageEvaluator;
import percentage.evaluator.impl.SimplePercentageEvaluator;

import static org.junit.Assert.assertEquals;

/**
 * Tests for Standard Markup evaluator
 *
 * @author "Simar Paul Singh"
 */
public class StandardMarkupEvaluatorTest {

    private static MarkupEvaluator simpleMarkupEvaluator;

    @BeforeClass
    public static void setUp() {
        simpleMarkupEvaluator = new StandardMarkupEvaluator(
                new SimplePercentageEvaluator(),
                new CompoundPercentageEvaluator());
    }

    /**
     * Test evaluation with Fixed Markup, 3 Persons Markup and Food Markup
     */
    @Test
    public void testMarkupEvaluation() {
        final double baseAmount = 1299.99d;
        final double amount = simpleMarkupEvaluator.evaluate(baseAmount, Markups.FIXED,
                Markups.PERSON, Markups.PERSON, Markups.PERSON,
                Markups.FOOD);
        assertEquals(1591.58d, amount, 0.01d);
    }

    /**
     * Test evaluation with Fixed Markup, and OTHER (0%) markup
     */
    @Test
    public void testMarkupEvaluationWithOther() {
        final double baseAmount = 1299.99d;
        final double amount = simpleMarkupEvaluator.evaluate(baseAmount, Markups.OTHER);
        assertEquals(1299.99d, amount, 0.01d);
    }
}
