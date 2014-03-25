package markup.calculator.impl;

import markup.calculator.MarkupCalculator;
import markup.evaluator.impl.StandardMarkupEvaluator;
import markup.model.impl.Markups;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Tests for Standard Markup Calculator
 *
 * @author "Simar Paul Singh"
 */
public class StandardMarkupCalculatorTest {

    private static MarkupCalculator calculator;

    @BeforeClass
    public static void setUp() {
        calculator = new StandardMarkupCalculator(new StandardMarkupEvaluator(),
                Markups.FIXED,
                Markups.PERSON);
    }

    /**
     * Input 1:
     * --------
     * $1299.99
     * 3 people
     * food
     * <p/>
     * Output 1: $1591.58
     */
    @Test
    public void testForThreePersonsAndFood() {

        double amount = calculator.calculate(1299.99, 3, Markups.FOOD);
        assertEquals(1591.58d, amount, 0.01);
    }

    /**
     * Input 2:
     * --------
     * $5432.00
     * 1 person
     * drugs
     * <p/>
     * Output 2: $6199.81
     */
    @Test
    public void testForOnePersonAndDrugs() {
        final double baseAmount = 5432.00d;
        final double amount = calculator.calculate(baseAmount, 1, Markups.PHARMACEUTICAL);
        assertEquals(6199.81d, amount, 0.01);
    }

    /**
     * Input 3:
     * --------
     * $12456.95
     * 4 people
     * books
     * <p/>
     * Output 3: $13707.63
     */
    @Test
    public void testWithFourPeopleAndBooks() {
        final double baseAmount = 12456.95d;
        final double amount = calculator.calculate(baseAmount, 4, Markups.OTHER);
        assertEquals(13707.63d, amount, .01d);
    }


}
