package percentage.evaluator.impl;

import percentage.evaluator.SimpleEvaluator;
import percentage.model.Percentage;
import percentage.model.impl.FixedPercentage;

/**
 * Implementation of Simple Percentage Evaluator
 *
 * @author "Simar Paul Singh"
 */
public class SimplePercentageEvaluator implements SimpleEvaluator {

    /**
     * {@inheritDoc}
     */
    @Override
    public Percentage evaluate(final Percentage... percentages) {
        double simplePercentage = 0;
        for (final Percentage nextPercentage : percentages) {
            simplePercentage += nextPercentage.getValue();
        }
        return new FixedPercentage(simplePercentage);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double simple(final double baseValue, final Percentage... percentages) {
        return baseValue * ((evaluate(percentages).getValue() / 100) + 1d);
    }
}
