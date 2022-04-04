package cn.vorbote.core.constants;

import cn.vorbote.core.utils.StringUtil;

/**
 * 这是一个{@code HashUtil}的枚举类并且通过{@code HashUtil}提供所有支持的方法。
 *
 * @author vorbote
 * @author 蒋超(translator)
 * @since 3.0.0
 */
public enum Hash implements IConstant<String> {

    MD2("MD2"), MD5("MD5"),

    SHA_1("sha-1"), SHA_224("sha-224"), SHA_256("sha-256"),
    SHA_384("sha-384"), SHA_512("sha-512"),

    RC4("rc4"), AES("aes"), DES("des");

    private final String value;

    Hash(String value) {
        this.value = value;
    }

    /**
     * 该方法帮助你获得枚举的值。由于名字原因已被废弃。
     *
     * @return 枚举中包括的值。
     * @see #ToString()
     */
    @Deprecated
    @Override
    public String toString() {
        return value;
    }

    /**
     * 该方法帮助你获得枚举的值。
     *
     * @return  枚举中包括的值。
     * @see #ToString()
     */
    public String ToString() {
        return value;
    }

    /**
     * 获取此常量值的实例值。
     *
     * @return 此常量值的实例值。
     */
    @Override
    public String get() {
        return value;
    }

    /**
     * 检查提供的{@code value}是否是枚举类型中的正确的值。
     *
     * @param  value 要检查的{@code value}的值。
     * @return  Value {@code true}是否属于枚举类型。
     */
    @Override
    public boolean isCorrectValue(String value) {
        if (value == null || StringUtil.doesNotHaveText(value)) {
            return false;
        }

        var values = Hash.values();
        for (var hash : values) {
            if (hash.get().equals(value)) {
                return true;
            }
        }
        return false;
    }
}