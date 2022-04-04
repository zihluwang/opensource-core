package cn.vorbote.core.constants;

/**
 * 月份的常量值
 *
 * @author vorbote
 * @author 蒋超(translator)
 */
public enum Month implements IConstant<Integer> {

    /**
     * 一月的常量值
     */
    JANUARY(1),

    /**
     * 二月的常量值
     */
    FEBRUARY(2),

    /**
     * 三月的常量值
     */
    MARCH(3),

    /**
     * 四月的常量值
     */
    APRIL(4),

    /**
     * 五月的常量值
     */
    MAY(5),

    /**
     * 六月的常量值
     */
    JUNE(6),

    /**
     * 七月的常量值
     */
    JULY(7),

    /**
     * 八月的常量值
     */
    AUGUST(8),

    /**
     * 九月的常量值
     */
    SEPTEMBER(9),

    /**
     * 十月的常量值
     */
    OCTOBER(10),

    /**
     * 十一月的常量值
     */
    NOVEMBER(11),

    /**
     * 十二月的常量值
     */
    DECEMBER(12);

    final int value;

    Month(int value) {
        this.value = value;
    }

    /**
     * 获得月份的值。
     *
     * @return 月份的值。
     */
    public int getValue() {
        return value;
    }

    /**
     * 获得该常量值的实例值。
     *
     * @return 该常量值的实例值。
     */
    public Integer get() {
        return getValue();
    }

    /**
     * 检查提供的{@code value}是否是枚举类型中的正确的值。
     *
     * @param  value 要检查的{@code value}的值。
     * @return  Value {@code true}是否属于枚举类型。
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