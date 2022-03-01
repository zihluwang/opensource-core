package cn.vorbote.core.constants;

/**
 * Month constant values.
 *
 * @author vorbote
 */
public enum Month implements IConstant<Integer> {

    /**
     * Constant value January
     */
    JANUARY(1),

    /**
     * Constant value FEBRUARY
     */
    FEBRUARY(2),

    /**
     * Constant value MARCH
     */
    MARCH(3),

    /**
     * Constant value APRIL
     */
    APRIL(4),

    /**
     * Constant value MAY
     */
    MAY(5),

    /**
     * Constant value JUNE
     */
    JUNE(6),

    /**
     * Constant value JULY
     */
    JULY(7),

    /**
     * Constant value AUGUST
     */
    AUGUST(8),

    /**
     * Constant value SEPTEMBER
     */
    SEPTEMBER(9),

    /**
     * Constant value OCTOBER
     */
    OCTOBER(10),

    /**
     * Constant value NOVEMBER
     */
    NOVEMBER(11),

    /**
     * Constant value DECEMBER
     */
    DECEMBER(12);

    final int value;

    Month(int value) {
        this.value = value;
    }

    /**
     * Get the month value.
     *
     * @return The month value.
     */
    public int getValue() {
        return value;
    }

    /**
     * Get the instance value of this constant value.
     *
     * @return The instance value of this constant value.
     */
    public Integer get() {
        return getValue();
    }

    /**
     * Check whether the provided {@code value} is a correct value of this enumeration.
     *
     * @param value The {@code value} to check.
     * @return Value {@code true} if the value is one of these enumerations.
     */
    @Override
    public boolean isCorrectValue(Integer value) {
        if (value == null) {
            return false;
        }

        var values = Month.values();
        for (var month : values) {
            if (month.get() == value) {
                return true;
            }
        }

        return false;
    }
}
