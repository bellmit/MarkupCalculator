package percentage.evaluator;

import percentage.model.Percentage;

/**
 * Strategy for Compounding Evaluator
 *
 * @author "Simar Paul Singh"
 */
public interface CompoundEvaluator extends PercentageEvaluator {

    /**
     * Compounds the base value with given var-arg (array) of percentages (in order)
     *
     * @param baseValue   base value to be compounded with given  percentages in order
     * @param percentages var-arg - array of percentages (ordered)
     * @return compounded value
     */
    double compound(final double baseValue, final Percentage... percentages);
}
