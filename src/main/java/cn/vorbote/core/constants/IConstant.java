package cn.vorbote.core.constants;

/**
 * The interface {@code IConstant} is the standard of all the enumerations in the class library.<br>
 * Created at 3/1/2022 11:06 PM.
 *
 * @author vorbote
 */
public interface IConstant<T> {

    /**
     * Get the instance value of this constant value.
     *
     * @return The instance value of this constant value.
     */
    T get();

    /**
     * Check whether the provided {@code value} is a correct value of this enumeration.
     *
     * @param value The {@code value} to check.
     * @return Value {@code true} if the value is one of these enumerations.
     */
    boolean isCorrectValue(T value);

}
