package cn.vorbote.core.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * CalculationUtil<br>
 * Created at 5/26/2022 11:31 PM
 *
 * @author sunzsh github.com:sunzsh
 */
public class CalculationUtil {

    private BigDecimal value;

    private CalculationUtil(Object value) {
        this.value = convertBigDecimal(value, null);
    }

    /**
     * The initial value of start.
     *
     * @param value The initial value.
     * @return The {@code CalculationUtil} instance.
     */
    public static CalculationUtil startOf(Object value) {
        return new CalculationUtil(value);
    }

    /**
     * Plus a number with this other number.
     *
     * @param other
     * @return
     */
    public CalculationUtil add(Number other) {
        return operator(BigDecimal::add, other);
    }

    /**
     * 加
     *
     * @param other
     * @param beforeOperateScale 加之前先把 other 四舍五入法保留 beforeOperateScale 位小数
     * @return
     */
    public CalculationUtil add(Number other, Integer beforeOperateScale) {
        return operator(BigDecimal::add, other, beforeOperateScale);
    }

    /**
     * 减
     *
     * @param other
     * @return
     */
    public CalculationUtil subtract(Number other) {
        return operator(BigDecimal::subtract, other);
    }

    /**
     * 减
     *
     * @param other
     * @param beforeOperateScale 减之前先把 other 四舍五入法保留 beforeOperteScale 位小数
     * @return
     */
    public CalculationUtil subtract(Number other, Integer beforeOperateScale) {
        return operator(BigDecimal::subtract, other, beforeOperateScale);
    }

    /**
     * 乘
     *
     * @param other
     * @return
     */
    public CalculationUtil multiply(Number other) {
        return operator(BigDecimal::multiply, other);
    }

    /**
     * 乘
     *
     * @param other
     * @param beforeOperateScale 乘之前先把 other 四舍五入法保留 beforeOperteScale 位小数
     * @return
     */
    public CalculationUtil multiply(Number other, Integer beforeOperateScale) {
        return operator(BigDecimal::multiply, other, beforeOperateScale);
    }

    /**
     * 除以
     *
     * @param other
     * @return
     */
    public CalculationUtil divide(Number other) {
        return operator(BigDecimal::divide, other);
    }

    /**
     * 除以
     *
     * @param other
     * @param beforeOperateScale 除之前先把 other 四舍五入法保留 beforeOperateScale 位小数
     * @return
     */
    public CalculationUtil divide(Number other, Integer beforeOperateScale) {
        return operator(BigDecimal::divide, other, beforeOperateScale);
    }

    /**
     * 除以
     *
     * @param other
     * @param scale 结果保留 scale 位小数
     * @return
     */
    public CalculationUtil divideWithScale(Number other, Integer scale) {
        return baseOperator(otherValue -> this.value.divide(otherValue, scale, RoundingMode.HALF_UP), other, null);
    }

    /**
     * 除以
     *
     * @param other
     * @param scale              结果保留 scale 位小数
     * @param beforeOperateScale 除以之前先把 other 四舍五入法保留 beforeOperteScale 位小数
     * @return
     */
    public CalculationUtil divideWithScale(Number other, Integer scale, Integer beforeOperateScale) {
        return baseOperator(otherValue -> this.value.divide(otherValue, scale, RoundingMode.HALF_UP), other, beforeOperateScale);
    }


    public BigDecimal getValue() {
        return value;
    }

    public BigDecimal getValue(int scale) {
        return value.setScale(scale, RoundingMode.HALF_UP);
    }

    public Double getDouble() {
        return getValue().doubleValue();
    }

    public Double getDouble(int scale) {
        return getValue(scale).doubleValue();
    }

    public Long getLong() {
        return getValue().longValue();
    }

    public Integer getInteger() {
        return getValue().intValue();
    }

    private CalculationUtil operator(BiFunction<BigDecimal, BigDecimal, BigDecimal> operator, Object other) {
        return operator(operator, other, null);
    }

    private CalculationUtil operator(BiFunction<BigDecimal, BigDecimal, BigDecimal> operator, Object other, Integer beforeOperteScale) {
        return baseOperator(otherValue -> operator.apply(this.value, otherValue), other, beforeOperteScale);
    }

    private synchronized CalculationUtil baseOperator(Function<BigDecimal, BigDecimal> operatorFunction, Object other, Integer beforeOperteScale) {
        if (other == null) {
            return this;
        }
        if (other instanceof CalculationUtil) {
            this.value = operatorFunction.apply(((CalculationUtil) other).getValue());
            return this;
        }
        this.value = operatorFunction.apply(convertBigDecimal(other, beforeOperteScale));
        return this;
    }

    private BigDecimal convertBigDecimal(Object value, Integer scale) {
        if (value == null) {
            return BigDecimal.ZERO;
        }
        BigDecimal res;
        if (value instanceof Number) {
            res = BigDecimal.valueOf(((Number) value).doubleValue());
        } else {
            try {
                res = new BigDecimal(value.toString());
            } catch (NumberFormatException e) {
                return BigDecimal.ZERO;
            }
        }

        if (scale != null) {
            res = BigDecimal.valueOf(res.setScale(scale, RoundingMode.HALF_UP).doubleValue());
        }
        return res;
    }

}
