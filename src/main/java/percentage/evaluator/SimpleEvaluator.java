package percentage.evaluator;

import percentage.model.Percentage;

/**
 * Strategy for Simple Evaluator
 *
 * @author "Simar Paul Singh"
 */
public interface SimpleEvaluator extends PercentageEvaluator {

    /**
     * Simple Evaluation of a given base value with given var-arg array of percentages
     *
     * @param baseValue   base value
     * @param percentages var-arg array of percentages
     * @return evaluated value
     */
    double simple(final double baseValue, final Percentage... percentages);
}
