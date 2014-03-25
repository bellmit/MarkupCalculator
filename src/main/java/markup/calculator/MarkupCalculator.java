package markup.calculator;

import markup.model.Markup;

/**
 * Strategy for Markup Calculations
 *
 * @author "Simar Paul Singh"
 */
public interface MarkupCalculator {


    /**
     * Calculates Markup, with given value, number of persons and material used
     *
     * @param baseValue       base value
     * @param numberOfPersons number of persons working
     * @param materialMarkup  markup for material used
     * @return calculated value
     */
    double calculate(final double baseValue, final int numberOfPersons, final Markup materialMarkup);
}
