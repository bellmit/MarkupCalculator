package markup.calculator.impl;

import markup.calculator.MarkupCalculator;
import markup.evaluator.MarkupEvaluator;
import markup.model.Markup;

/**
 * Implementation of Standard Markup Calculator
 *
 * @author "Simar Paul Singh"
 */
public class StandardMarkupCalculator implements MarkupCalculator {


    private final MarkupEvaluator evaluator;

    private final Markup fixedMarkup;

    private final Markup markupForEachPerson;

    /**
     * Constructs Standard Markup Calculator with Given Dependencies
     *
     * @param evaluator           markup evaluator
     * @param fixedMarkup         fixed markup
     * @param markupForEachPerson markup for each person
     */
    public StandardMarkupCalculator(final MarkupEvaluator evaluator,
                                    final Markup fixedMarkup,
                                    final Markup markupForEachPerson) {
        super();
        this.evaluator = evaluator;
        this.fixedMarkup = fixedMarkup;
        this.markupForEachPerson = markupForEachPerson;
    }


    @Override
    public double calculate(final double baseValue, final int numberOfPersons, final Markup materialMarkup) {
        return this.evaluator.evaluate(baseValue, this.fixedMarkup, new Markup() {
            @Override
            public double getValue() {
                return StandardMarkupCalculator.this.markupForEachPerson.getValue() * numberOfPersons;
            }
        }, materialMarkup);
    }
}
