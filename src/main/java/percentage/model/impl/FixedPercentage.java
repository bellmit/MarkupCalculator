package percentage.model.impl;

import percentage.model.Percentage;

/**
 * Fixed Percentage
 *
 * @author "Simar Paul Singh"
 */
public class FixedPercentage implements Percentage {

    private final double fixedPercentage;

    /**
     * Constructs a Fixed Percentage
     * <p/>
     * Ex. 12d would mean 12%
     *
     * @param fixedPercentageValue fixed percentage value
     */
    public FixedPercentage(final double fixedPercentageValue) {
        super();
        if (0d > fixedPercentageValue) {
            throw new IllegalArgumentException("Invalid value of less than zero: " + fixedPercentageValue);
        }
        this.fixedPercentage = fixedPercentageValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getValue() {
        return this.fixedPercentage;
    }

}
