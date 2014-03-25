package percentage.evaluator;


import percentage.model.Percentage;

/**
 * Strategy for Percentage Evaluator
 *
 * @author "Simar Paul Singh"
 */
public interface PercentageEvaluator {

    /**
     * Evaluates var arg array of percentages into a final percentage
     *
     * @param percentages input var-arg (array) of percentages
     * @return evaluated percentage
     */
    Percentage evaluate(final Percentage... percentages);
}
