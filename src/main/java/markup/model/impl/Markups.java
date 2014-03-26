package markup.model.impl;

import markup.model.Markup;

/**
 * Enumerates Markup of Different Types
 *
 * @author "Simar Paul Singh"
 */
public enum Markups implements Markup {

    PHARMACEUTICAL(7.5f), FOOD(13f), ELECTRONICS(2f), PERSON(1.2f), OTHER(0f), FIXED(5f);

    private final double markupPercentage;

    Markups(final double markupPercentage) {
        if (0 > markupPercentage) {
            throw new IllegalArgumentException("Markup Factor should be greater than 0");
        }
        this.markupPercentage = markupPercentage;
    }

    @Override
    public double getValue() {
        return this.markupPercentage;
    }
}
