package cn.vorbote.core.exceptions;

/**
 * This exception means the specified jwt algorithm is not supported.
 *
 * @author vorbote
 * @since 3.0.0
 */
public class UnsupportedJwtAlgorithmException extends RuntimeException {
    public UnsupportedJwtAlgorithmException() {
        super();
    }

    public UnsupportedJwtAlgorithmException(String message) {
        super(message);
    }
}
