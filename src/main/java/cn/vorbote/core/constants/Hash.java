package cn.vorbote.core.constants;

/**
 * This is an enum class for {@code HashUtil} and supplied  all supported methods by the {@code HashUtil}.
 *
 * @author vorbote
 * @since 3.0.0
 */
public enum Hash {

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
     * @see #ToString()
     */
    @Deprecated
    @Override
    public String toString() {
        return value;
    }

    /**
     * This method helps you get the value of the enum.
     *
     * @return The value included in this enum.
     * @see #ToString()
     */
    public String ToString() {
        return value;
    }
}
