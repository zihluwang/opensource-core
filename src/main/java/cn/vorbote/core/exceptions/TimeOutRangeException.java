package cn.vorbote.core.exceptions;

/**
 * Time value out of its range exception.
 *
 * @author vorbote
 */
public class TimeOutRangeException extends RuntimeException {

    public TimeOutRangeException() {
    }

    public TimeOutRangeException(String message) {
        super(message);
    }
}
