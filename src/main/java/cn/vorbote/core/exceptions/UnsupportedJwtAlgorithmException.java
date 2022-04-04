package cn.vorbote.core.exceptions;

/**
 * 这个异常意味着指定的jwt算法不被支持。
 *
 * @author vorbote
 * @author 蒋超(translator)
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