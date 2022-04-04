package cn.vorbote.core.exceptions;

/**
 * 如果时间里的特点字段值超出它的正确范围，该异常将被抛出。
 * 例如，如果你设置“minute”字段为60将或引起这个异常
 *
 * @author vorbote
 * @author 蒋超(translator)
 */
public class TimeOutRangeException extends RuntimeException {

    /**
     * 异常的信息，告诉编程者哪个字段是错误的。
     */
    private final String message;

    /**
     * 构造器，创建一个清楚的异常信息。
     *
     * @param field               被设置为错误值的字段。
     * @param correctMinimumValue 该字段的最小正确值。
     * @param correctMaximumValue 该字段的最大正确值。
     */
    public TimeOutRangeException(String field, Integer correctMinimumValue, Integer correctMaximumValue) {
        message = String.format("The %s is out of range of (%d ~ %d).", field, correctMinimumValue,
                correctMaximumValue);
    }

    /**
     * 转化成一个{@code String}使编程者更加清楚这个异常信息。
     *
     * @return 一个{@code String}包含了哪里出错。
     */
    @Override
    public String toString() {
        return message;
    }

    /**
     * 转化成一个{@code String}使编程者更加清楚这个异常信息。
     *
     * @return 一个{@code String}包含了哪里出错。
     * @see #toString()
     */
    @Override
    public String getMessage() {
        return message;
    }
}