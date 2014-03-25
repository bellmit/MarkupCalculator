package markup.evaluator.impl;

import markup.evaluator.MarkupEvaluator;
import markup.model.Markup;
import percentage.evaluator.CompoundEvaluator;
import percentage.evaluator.SimpleEvaluator;
import percentage.evaluator.impl.CompoundPercentageEvaluator;
import percentage.evaluator.impl.SimplePercentageEvaluator;

/**
 * Implementation of Markup Evaluator
 *
 * @author "Simar Paul Singh"
 */
public class StandardMarkupEvaluator implements MarkupEvaluator {


    private final SimpleEvaluator simpleEvaluator;
    private final CompoundEvaluator compoundEvaluator;

    /**
     * Constructs Standard Markup Evaluator with standard dependencies
     */
    public StandardMarkupEvaluator() {
        this(new SimplePercentageEvaluator(),
                new CompoundPercentageEvaluator());
    }

    /**
     * Constructs Standard Markup Evaluator with given dependencies
     *
     * @param simpleEvaluator   simple evaluator
     * @param compoundEvaluator compounding evaluator
     */
    public StandardMarkupEvaluator(final SimpleEvaluator simpleEvaluator, final CompoundEvaluator compoundEvaluator) {
        super();
        this.simpleEvaluator = simpleEvaluator;
        this.compoundEvaluator = compoundEvaluator;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public double evaluate(final double baseValue, final Markup fixedMarkup, final Markup... markups) {
        final double percentage;
        percentage = this.compoundEvaluator.evaluate(fixedMarkup, this.simpleEvaluator.evaluate(markups)).getValue();
        return baseValue * (1d + (percentage / 100d));
    }

}
