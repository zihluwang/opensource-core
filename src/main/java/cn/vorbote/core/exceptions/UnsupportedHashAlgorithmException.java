package cn.vorbote.core.exceptions;

/**
 * This exception means the specified jwt algorithm is not supported.
 *
 * @author vorbote
 * @since 3.0.0
 */
public class UnsupportedHashAlgorithmException extends RuntimeException {
    public UnsupportedHashAlgorithmException() {
        super();
    }

    public UnsupportedHashAlgorithmException(String message) {
        super(message);
    }
}
