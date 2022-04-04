package cn.vorbote.core.constants;

/**
 * {@code IConstant}接口是所有类库中枚举类型的标准。
 * 创建时间：3/1/2022 11:06 PM。
 *
 * @author vorbote
 * @author 蒋超(translator)
 */
public interface IConstant<T> {

    /**
     * 获得该常量值的实例值。
     *
     * @return 该常量值的实例值。
     */
    T get();

    /**
     * 检查提供的{@code value}是否是枚举类型中的正确的值。
     *
     * @param  value 要检查的{@code value}的值。
     * @return  Value {@code true}是否属于枚举类型。
     */
    boolean isCorrectValue(T value);

}