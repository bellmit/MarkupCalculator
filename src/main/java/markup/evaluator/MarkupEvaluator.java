package markup.evaluator;

import markup.model.Markup;

/**
 * Strategy for Markup Evaluation
 *
 * @author "Simar Paul Singh"
 */
public interface MarkupEvaluator {
    /**
     * Evaluates final value, with given base value, a given fixed markup and var arg array of markups
     *
     * @param baseValue   base value
     * @param fixedMarkup fixed markup
     * @param markups     var-arg array of markups
     * @return evaluated final value
     */
    double evaluate(final double baseValue, final Markup fixedMarkup, final Markup... markups);
}
