package cn.vorbote.core.constants;

import cn.vorbote.core.utils.StringUtil;

/**
 * This is an enum class for {@code HashUtil} and supplied  all supported methods by the {@code HashUtil}.
 *
 * @author vorbote
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
     * This method helps you get the value of the enum. Deprecated
     * because of its name.
     *
     * @return The value included in this enum.
     */
    @Override
    public String toString() {
        return value;
    }

    /**
     * Get the instance value of this constant value.
     *
     * @return The instance value of this constant value.
     */
    @Override
    public String get() {
        return value;
    }

    /**
     * Check whether the provided {@code value} is a correct value of this enumeration.
     *
     * @param value The {@code value} to check.
     * @return Value {@code true} if the value is one of these enumerations.
     */
    @Override
    public boolean isCorrectValue(String value) {
        if (value == null || StringUtil.doesNotHaveText(value)) {
            return false;
        }

        Hash[] values = Hash.values();
        for (Hash hash : values) {
            if (hash.get().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
