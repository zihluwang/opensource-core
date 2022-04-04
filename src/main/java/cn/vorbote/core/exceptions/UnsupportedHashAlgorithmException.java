package cn.vorbote.core.exceptions;

/**
 * 这个异常意味着指定的jwt算法不被支持。
 *
 * @author vorbote
 * @author 蒋超(translator)
 * @since 3.0.0
 */
public class UnsupportedHashAlgorithmException extends RuntimeException {

    private final String message;

    public UnsupportedHashAlgorithmException(String algorithm) {
        message = String.format("Unsupported algorithm %s.", algorithm);
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}